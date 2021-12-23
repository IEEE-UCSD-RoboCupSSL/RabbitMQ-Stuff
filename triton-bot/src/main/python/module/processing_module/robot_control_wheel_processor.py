from pickle import loads
from config.config_path import ConfigPath
from config.config_reader import read_config
from generated_sources.proto.ssl_simulation_robot_control_pb2 import RobotCommand, RobotControl
from messaging.exchange import Exchange
from module.module import Module


class RobotControlWheelProcessor(Module):
    def __init__(self):
        super().__init__()

    def load_config(self):
        super().load_config()
        self.network_config = read_config(
            ConfigPath.NETWORK_CONFIG)

    def prepare(self):
        super().prepare()

    def declare_exchanges(self):
        super().declare_exchanges()
        self.declare_consume(exchange=Exchange.TB_WHEEL_COMMAND, callback=self.callback_wheel_command)
        self.declare_publish(exchange=Exchange.TB_ROBOT_CONTROL)
    
    def run(self):
        super().run()
        self.consume()
    
    def callback_wheel_command(self, ch, method, properties, body):
        wheel_command = RobotCommand()
        wheel_command.ParseFromString(body)
        robot_control = RobotControl()
        robot_control.robot_commands.append(wheel_command)
        self.publish(exchange=Exchange.TB_ROBOT_CONTROL, object=robot_control)