from main.python.messaging.exchange import Exchange
from module import module


import pickle


class ModuleB(module.Module):
    def __init__(self):
        super().__init__()

    def declare_exchanges(self):
        super().declare_exchanges()
        self.declare_consume(exchange=Exchange.DATA_A, callback=self.callback)

    def callback(self, ch, method, properties, body):
        message = pickle.loads(body)
        print(message)
