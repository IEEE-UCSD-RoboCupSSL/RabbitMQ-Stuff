# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: messages_robocup_ssl_detection_tracked.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf.internal import enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='messages_robocup_ssl_detection_tracked.proto',
  package='proto.vision',
  syntax='proto2',
  serialized_options=None,
  serialized_pb=_b('\n,messages_robocup_ssl_detection_tracked.proto\x12\x0cproto.vision\"\x1f\n\x07Vector2\x12\t\n\x01x\x18\x01 \x02(\x02\x12\t\n\x01y\x18\x02 \x02(\x02\"*\n\x07Vector3\x12\t\n\x01x\x18\x01 \x02(\x02\x12\t\n\x01y\x18\x02 \x02(\x02\x12\t\n\x01z\x18\x03 \x02(\x02\"B\n\x07RobotId\x12\n\n\x02id\x18\x01 \x02(\r\x12+\n\nteam_color\x18\x02 \x02(\x0e\x32\x17.proto.vision.TeamColor\"i\n\x0bTrackedBall\x12\"\n\x03pos\x18\x01 \x02(\x0b\x32\x15.proto.vision.Vector3\x12\"\n\x03vel\x18\x02 \x01(\x0b\x32\x15.proto.vision.Vector3\x12\x12\n\nvisibility\x18\x03 \x01(\x02\"\xd7\x01\n\nKickedBall\x12\"\n\x03pos\x18\x01 \x02(\x0b\x32\x15.proto.vision.Vector2\x12\"\n\x03vel\x18\x02 \x02(\x0b\x32\x15.proto.vision.Vector3\x12\x17\n\x0fstart_timestamp\x18\x03 \x02(\x01\x12\x16\n\x0estop_timestamp\x18\x04 \x01(\x01\x12\'\n\x08stop_pos\x18\x05 \x01(\x0b\x32\x15.proto.vision.Vector2\x12\'\n\x08robot_id\x18\x06 \x01(\x0b\x32\x15.proto.vision.RobotId\"\xbd\x01\n\x0cTrackedRobot\x12\'\n\x08robot_id\x18\x01 \x02(\x0b\x32\x15.proto.vision.RobotId\x12\"\n\x03pos\x18\x02 \x02(\x0b\x32\x15.proto.vision.Vector2\x12\x13\n\x0borientation\x18\x03 \x02(\x02\x12\"\n\x03vel\x18\x04 \x01(\x0b\x32\x15.proto.vision.Vector2\x12\x13\n\x0bvel_angular\x18\x05 \x01(\x02\x12\x12\n\nvisibility\x18\x06 \x01(\x02\"\xec\x01\n\x0cTrackedFrame\x12\x14\n\x0c\x66rame_number\x18\x01 \x02(\r\x12\x11\n\ttimestamp\x18\x02 \x02(\x01\x12(\n\x05\x62\x61lls\x18\x03 \x03(\x0b\x32\x19.proto.vision.TrackedBall\x12*\n\x06robots\x18\x04 \x03(\x0b\x32\x1a.proto.vision.TrackedRobot\x12-\n\x0bkicked_ball\x18\x05 \x01(\x0b\x32\x18.proto.vision.KickedBall\x12.\n\x0c\x63\x61pabilities\x18\x06 \x03(\x0e\x32\x18.proto.vision.Capability*O\n\tTeamColor\x12\x16\n\x12TEAM_COLOR_UNKNOWN\x10\x00\x12\x15\n\x11TEAM_COLOR_YELLOW\x10\x01\x12\x13\n\x0fTEAM_COLOR_BLUE\x10\x02*\x92\x01\n\nCapability\x12\x16\n\x12\x43\x41PABILITY_UNKNOWN\x10\x00\x12\"\n\x1e\x43\x41PABILITY_DETECT_FLYING_BALLS\x10\x01\x12$\n CAPABILITY_DETECT_MULTIPLE_BALLS\x10\x02\x12\"\n\x1e\x43\x41PABILITY_DETECT_KICKED_BALLS\x10\x03')
)

_TEAMCOLOR = _descriptor.EnumDescriptor(
  name='TeamColor',
  full_name='proto.vision.TeamColor',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='TEAM_COLOR_UNKNOWN', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='TEAM_COLOR_YELLOW', index=1, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='TEAM_COLOR_BLUE', index=2, number=2,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=963,
  serialized_end=1042,
)
_sym_db.RegisterEnumDescriptor(_TEAMCOLOR)

TeamColor = enum_type_wrapper.EnumTypeWrapper(_TEAMCOLOR)
_CAPABILITY = _descriptor.EnumDescriptor(
  name='Capability',
  full_name='proto.vision.Capability',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='CAPABILITY_UNKNOWN', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='CAPABILITY_DETECT_FLYING_BALLS', index=1, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='CAPABILITY_DETECT_MULTIPLE_BALLS', index=2, number=2,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='CAPABILITY_DETECT_KICKED_BALLS', index=3, number=3,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=1045,
  serialized_end=1191,
)
_sym_db.RegisterEnumDescriptor(_CAPABILITY)

Capability = enum_type_wrapper.EnumTypeWrapper(_CAPABILITY)
TEAM_COLOR_UNKNOWN = 0
TEAM_COLOR_YELLOW = 1
TEAM_COLOR_BLUE = 2
CAPABILITY_UNKNOWN = 0
CAPABILITY_DETECT_FLYING_BALLS = 1
CAPABILITY_DETECT_MULTIPLE_BALLS = 2
CAPABILITY_DETECT_KICKED_BALLS = 3



_VECTOR2 = _descriptor.Descriptor(
  name='Vector2',
  full_name='proto.vision.Vector2',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='x', full_name='proto.vision.Vector2.x', index=0,
      number=1, type=2, cpp_type=6, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='y', full_name='proto.vision.Vector2.y', index=1,
      number=2, type=2, cpp_type=6, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=62,
  serialized_end=93,
)


_VECTOR3 = _descriptor.Descriptor(
  name='Vector3',
  full_name='proto.vision.Vector3',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='x', full_name='proto.vision.Vector3.x', index=0,
      number=1, type=2, cpp_type=6, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='y', full_name='proto.vision.Vector3.y', index=1,
      number=2, type=2, cpp_type=6, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='z', full_name='proto.vision.Vector3.z', index=2,
      number=3, type=2, cpp_type=6, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=95,
  serialized_end=137,
)


_ROBOTID = _descriptor.Descriptor(
  name='RobotId',
  full_name='proto.vision.RobotId',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='proto.vision.RobotId.id', index=0,
      number=1, type=13, cpp_type=3, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='team_color', full_name='proto.vision.RobotId.team_color', index=1,
      number=2, type=14, cpp_type=8, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=139,
  serialized_end=205,
)


_TRACKEDBALL = _descriptor.Descriptor(
  name='TrackedBall',
  full_name='proto.vision.TrackedBall',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='pos', full_name='proto.vision.TrackedBall.pos', index=0,
      number=1, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='vel', full_name='proto.vision.TrackedBall.vel', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='visibility', full_name='proto.vision.TrackedBall.visibility', index=2,
      number=3, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=207,
  serialized_end=312,
)


_KICKEDBALL = _descriptor.Descriptor(
  name='KickedBall',
  full_name='proto.vision.KickedBall',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='pos', full_name='proto.vision.KickedBall.pos', index=0,
      number=1, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='vel', full_name='proto.vision.KickedBall.vel', index=1,
      number=2, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='start_timestamp', full_name='proto.vision.KickedBall.start_timestamp', index=2,
      number=3, type=1, cpp_type=5, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='stop_timestamp', full_name='proto.vision.KickedBall.stop_timestamp', index=3,
      number=4, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='stop_pos', full_name='proto.vision.KickedBall.stop_pos', index=4,
      number=5, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='robot_id', full_name='proto.vision.KickedBall.robot_id', index=5,
      number=6, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=315,
  serialized_end=530,
)


_TRACKEDROBOT = _descriptor.Descriptor(
  name='TrackedRobot',
  full_name='proto.vision.TrackedRobot',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='robot_id', full_name='proto.vision.TrackedRobot.robot_id', index=0,
      number=1, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='pos', full_name='proto.vision.TrackedRobot.pos', index=1,
      number=2, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='orientation', full_name='proto.vision.TrackedRobot.orientation', index=2,
      number=3, type=2, cpp_type=6, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='vel', full_name='proto.vision.TrackedRobot.vel', index=3,
      number=4, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='vel_angular', full_name='proto.vision.TrackedRobot.vel_angular', index=4,
      number=5, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='visibility', full_name='proto.vision.TrackedRobot.visibility', index=5,
      number=6, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=533,
  serialized_end=722,
)


_TRACKEDFRAME = _descriptor.Descriptor(
  name='TrackedFrame',
  full_name='proto.vision.TrackedFrame',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='frame_number', full_name='proto.vision.TrackedFrame.frame_number', index=0,
      number=1, type=13, cpp_type=3, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='timestamp', full_name='proto.vision.TrackedFrame.timestamp', index=1,
      number=2, type=1, cpp_type=5, label=2,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='balls', full_name='proto.vision.TrackedFrame.balls', index=2,
      number=3, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='robots', full_name='proto.vision.TrackedFrame.robots', index=3,
      number=4, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='kicked_ball', full_name='proto.vision.TrackedFrame.kicked_ball', index=4,
      number=5, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='capabilities', full_name='proto.vision.TrackedFrame.capabilities', index=5,
      number=6, type=14, cpp_type=8, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=725,
  serialized_end=961,
)

_ROBOTID.fields_by_name['team_color'].enum_type = _TEAMCOLOR
_TRACKEDBALL.fields_by_name['pos'].message_type = _VECTOR3
_TRACKEDBALL.fields_by_name['vel'].message_type = _VECTOR3
_KICKEDBALL.fields_by_name['pos'].message_type = _VECTOR2
_KICKEDBALL.fields_by_name['vel'].message_type = _VECTOR3
_KICKEDBALL.fields_by_name['stop_pos'].message_type = _VECTOR2
_KICKEDBALL.fields_by_name['robot_id'].message_type = _ROBOTID
_TRACKEDROBOT.fields_by_name['robot_id'].message_type = _ROBOTID
_TRACKEDROBOT.fields_by_name['pos'].message_type = _VECTOR2
_TRACKEDROBOT.fields_by_name['vel'].message_type = _VECTOR2
_TRACKEDFRAME.fields_by_name['balls'].message_type = _TRACKEDBALL
_TRACKEDFRAME.fields_by_name['robots'].message_type = _TRACKEDROBOT
_TRACKEDFRAME.fields_by_name['kicked_ball'].message_type = _KICKEDBALL
_TRACKEDFRAME.fields_by_name['capabilities'].enum_type = _CAPABILITY
DESCRIPTOR.message_types_by_name['Vector2'] = _VECTOR2
DESCRIPTOR.message_types_by_name['Vector3'] = _VECTOR3
DESCRIPTOR.message_types_by_name['RobotId'] = _ROBOTID
DESCRIPTOR.message_types_by_name['TrackedBall'] = _TRACKEDBALL
DESCRIPTOR.message_types_by_name['KickedBall'] = _KICKEDBALL
DESCRIPTOR.message_types_by_name['TrackedRobot'] = _TRACKEDROBOT
DESCRIPTOR.message_types_by_name['TrackedFrame'] = _TRACKEDFRAME
DESCRIPTOR.enum_types_by_name['TeamColor'] = _TEAMCOLOR
DESCRIPTOR.enum_types_by_name['Capability'] = _CAPABILITY
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

Vector2 = _reflection.GeneratedProtocolMessageType('Vector2', (_message.Message,), dict(
  DESCRIPTOR = _VECTOR2,
  __module__ = 'messages_robocup_ssl_detection_tracked_pb2'
  # @@protoc_insertion_point(class_scope:proto.vision.Vector2)
  ))
_sym_db.RegisterMessage(Vector2)

Vector3 = _reflection.GeneratedProtocolMessageType('Vector3', (_message.Message,), dict(
  DESCRIPTOR = _VECTOR3,
  __module__ = 'messages_robocup_ssl_detection_tracked_pb2'
  # @@protoc_insertion_point(class_scope:proto.vision.Vector3)
  ))
_sym_db.RegisterMessage(Vector3)

RobotId = _reflection.GeneratedProtocolMessageType('RobotId', (_message.Message,), dict(
  DESCRIPTOR = _ROBOTID,
  __module__ = 'messages_robocup_ssl_detection_tracked_pb2'
  # @@protoc_insertion_point(class_scope:proto.vision.RobotId)
  ))
_sym_db.RegisterMessage(RobotId)

TrackedBall = _reflection.GeneratedProtocolMessageType('TrackedBall', (_message.Message,), dict(
  DESCRIPTOR = _TRACKEDBALL,
  __module__ = 'messages_robocup_ssl_detection_tracked_pb2'
  # @@protoc_insertion_point(class_scope:proto.vision.TrackedBall)
  ))
_sym_db.RegisterMessage(TrackedBall)

KickedBall = _reflection.GeneratedProtocolMessageType('KickedBall', (_message.Message,), dict(
  DESCRIPTOR = _KICKEDBALL,
  __module__ = 'messages_robocup_ssl_detection_tracked_pb2'
  # @@protoc_insertion_point(class_scope:proto.vision.KickedBall)
  ))
_sym_db.RegisterMessage(KickedBall)

TrackedRobot = _reflection.GeneratedProtocolMessageType('TrackedRobot', (_message.Message,), dict(
  DESCRIPTOR = _TRACKEDROBOT,
  __module__ = 'messages_robocup_ssl_detection_tracked_pb2'
  # @@protoc_insertion_point(class_scope:proto.vision.TrackedRobot)
  ))
_sym_db.RegisterMessage(TrackedRobot)

TrackedFrame = _reflection.GeneratedProtocolMessageType('TrackedFrame', (_message.Message,), dict(
  DESCRIPTOR = _TRACKEDFRAME,
  __module__ = 'messages_robocup_ssl_detection_tracked_pb2'
  # @@protoc_insertion_point(class_scope:proto.vision.TrackedFrame)
  ))
_sym_db.RegisterMessage(TrackedFrame)


# @@protoc_insertion_point(module_scope)