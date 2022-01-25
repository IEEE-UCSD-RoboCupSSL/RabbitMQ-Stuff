import pickle
from threading import Thread

from google.protobuf.message import Message
from constant.runtime_constants import RuntimeConstants
import pika

class Module(Thread):
    CONNECTION_FACTORY_HOST = 'localhost'
    FANOUT = 'fanout'

    def __init__(self):
        super().__init__()
        self.setup_channels()
        self.load_config()
        self.prepare()
        self.declare_publishes()
        self.declare_consumes()

    def setup_channels(self):
        self.consume_connection = pika.BlockingConnection(
            pika.ConnectionParameters(Module.CONNECTION_FACTORY_HOST, heartbeat=10))
        self.consume_channel = self.consume_connection.channel()

        self.publish_connection = pika.BlockingConnection(
            pika.ConnectionParameters(Module.CONNECTION_FACTORY_HOST, heartbeat=10))
        self.publish_channel = self.publish_connection.channel()

    def load_config(self):
        pass

    def prepare(self):
        pass

    def declare_publishes(self):
        pass

    def declare_consumes(self):
        pass

    def declare_publish(self, exchange):
        self.publish_channel.exchange_declare(
            exchange=exchange.name + str(RuntimeConstants.team) + str(RuntimeConstants.id), exchange_type=Module.FANOUT)

    def declare_consume(self, exchange, callback):
        self.consume_channel.exchange_declare(
            exchange=exchange.name + str(RuntimeConstants.team) + str(RuntimeConstants.id), exchange_type=Module.FANOUT)

        queue_name = self.consume_channel.queue_declare(
            queue='', exclusive=True).method.queue
        self.consume_channel.queue_bind(exchange=exchange.name + str(RuntimeConstants.team) + str(RuntimeConstants.id), queue=queue_name)

        self.consume_channel.basic_consume(
            queue=queue_name, on_message_callback=callback, auto_ack=True)

    def publish(self, exchange, object):
        if (isinstance(object, Message)):
            body = object.SerializeToString()
        else:
            body = pickle.dumps(object)

        self.publish_channel.basic_publish(
            exchange=exchange.name + str(RuntimeConstants.team) + str(RuntimeConstants.id), routing_key='', body=body)
    
    def consume(self):
        self.consume_channel.start_consuming()