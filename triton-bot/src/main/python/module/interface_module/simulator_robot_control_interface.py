from pickle import loads

from config.config_path import ConfigPath
from config.config_reader import read_config
from constant.runtime_constants import RuntimeConstants
from constant.team import Team
from generated_sources.proto.ssl_simulation_robot_feedback_pb2 import RobotControlResponse
from generated_sources.proto.ssl_simulation_robot_control_pb2 import RobotControl
from messaging.exchange import Exchange
from module.module import Module
from networking.udp_client import UDP_Client


class SimulatorRobotControlInterface(Module):
    def __init__(self):
        super().__init__()

    def load_config(self):
        super().load_config()
        self.network_config = read_config(
            ConfigPath.NETWORK_CONFIG)

    def prepare(self):
        super().prepare()
        self.setup_client()

    def declare_exchanges(self):
        super().declare_exchanges()
        self.declare_consume(Exchange.TB_ROBOT_CONTROL,
                             self.callback_robot_control)

    def run(self):
        super().run()
        self.consume()

    def setup_client(self):
        if (RuntimeConstants.team == Team.YELLOW):
            ally_control_address = self.network_config['simulationRobotControlAddressYellow']
            ally_control_port = self.network_config['simulationRobotControlPortYellow']
        else:
            ally_control_address = self.network_config['simulationRobotControlAddressBlue']
            ally_control_port = self.network_config['simulationRobotControlPortBlue']

        self.client = UDP_Client(
            server_address=ally_control_address,
            server_port=ally_control_port,
            callback=self.callback_robot_control_response)
        self.client.start()

    def callback_robot_control(self, ch, method, properties, body):
        robot_control = RobotControl()
        robot_control.ParseFromString(body)
        self.client.add_send(robot_control.SerializeToString())

    def callback_robot_control_response(self,bytes):
        response = RobotControlResponse()
        response.ParseFromString(bytes)
        print(response)