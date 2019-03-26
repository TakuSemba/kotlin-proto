// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.TagHandler
import com.squareup.wire.WireField
import com.squareup.wire.internal.Internal
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * Describes a message type.
 */
data class DescriptorProto(
  @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#STRING") val name: String? =
      null,
  @field:WireField(tag = 2, adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER") val field:
      List<FieldDescriptorProto> = emptyList(),
  @field:WireField(tag = 6, adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER")
      val extension: List<FieldDescriptorProto> = emptyList(),
  @field:WireField(tag = 3, adapter = "com.google.protobuf.DescriptorProto#ADAPTER")
      val nested_type: List<DescriptorProto> = emptyList(),
  @field:WireField(tag = 4, adapter = "com.google.protobuf.EnumDescriptorProto#ADAPTER")
      val enum_type: List<EnumDescriptorProto> = emptyList(),
  @field:WireField(tag = 5, adapter = "com.google.protobuf.DescriptorProto.ExtensionRange#ADAPTER")
      val extension_range: List<ExtensionRange> = emptyList(),
  @field:WireField(tag = 8, adapter = "com.google.protobuf.OneofDescriptorProto#ADAPTER")
      val oneof_decl: List<OneofDescriptorProto> = emptyList(),
  @field:WireField(tag = 7, adapter = "com.google.protobuf.MessageOptions#ADAPTER") val options:
      MessageOptions? = null,
  @field:WireField(tag = 9, adapter = "com.google.protobuf.DescriptorProto.ReservedRange#ADAPTER")
      val reserved_range: List<ReservedRange> = emptyList(),
  /**
   * Reserved field names, which may not be used by fields in the same message.
   * A given name may only be reserved once.
   */
  @field:WireField(tag = 10, adapter = "com.squareup.wire.ProtoAdapter#STRING") val reserved_name:
      List<String> = emptyList(),
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<DescriptorProto, DescriptorProto.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: DescriptorProto) : Message.Builder<DescriptorProto, Builder>()
      {
    override fun build(): DescriptorProto = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<DescriptorProto> = object : ProtoAdapter<DescriptorProto>(
      FieldEncoding.LENGTH_DELIMITED, 
      DescriptorProto::class.java
    ) {
      override fun encodedSize(value: DescriptorProto): Int = 
        ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) +
        FieldDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, value.field) +
        FieldDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(6, value.extension) +
        DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(3, value.nested_type) +
        EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, value.enum_type) +
        ExtensionRange.ADAPTER.asRepeated().encodedSizeWithTag(5, value.extension_range) +
        OneofDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(8, value.oneof_decl) +
        MessageOptions.ADAPTER.encodedSizeWithTag(7, value.options) +
        ReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(9, value.reserved_range) +
        ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(10, value.reserved_name) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: DescriptorProto) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        FieldDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.field)
        FieldDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.extension)
        DescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.nested_type)
        EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.enum_type)
        ExtensionRange.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.extension_range)
        OneofDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.oneof_decl)
        MessageOptions.ADAPTER.encodeWithTag(writer, 7, value.options)
        ReservedRange.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.reserved_range)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 10, value.reserved_name)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): DescriptorProto {
        var name: String? = null
        val field = mutableListOf<FieldDescriptorProto>()
        val extension = mutableListOf<FieldDescriptorProto>()
        val nested_type = mutableListOf<DescriptorProto>()
        val enum_type = mutableListOf<EnumDescriptorProto>()
        val extension_range = mutableListOf<ExtensionRange>()
        val oneof_decl = mutableListOf<OneofDescriptorProto>()
        var options: MessageOptions? = null
        val reserved_range = mutableListOf<ReservedRange>()
        val reserved_name = mutableListOf<String>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> field.add(FieldDescriptorProto.ADAPTER.decode(reader))
            6 -> extension.add(FieldDescriptorProto.ADAPTER.decode(reader))
            3 -> nested_type.add(DescriptorProto.ADAPTER.decode(reader))
            4 -> enum_type.add(EnumDescriptorProto.ADAPTER.decode(reader))
            5 -> extension_range.add(ExtensionRange.ADAPTER.decode(reader))
            8 -> oneof_decl.add(OneofDescriptorProto.ADAPTER.decode(reader))
            7 -> options = MessageOptions.ADAPTER.decode(reader)
            9 -> reserved_range.add(ReservedRange.ADAPTER.decode(reader))
            10 -> reserved_name.add(ProtoAdapter.STRING.decode(reader))
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return DescriptorProto(
          name = name,
          field = field,
          extension = extension,
          nested_type = nested_type,
          enum_type = enum_type,
          extension_range = extension_range,
          oneof_decl = oneof_decl,
          options = options,
          reserved_range = reserved_range,
          reserved_name = reserved_name,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: DescriptorProto): DescriptorProto? = value.copy(
        field = value.field.also { Internal.redactElements(it, FieldDescriptorProto.ADAPTER) },
        extension = value.extension.also { Internal.redactElements(it, FieldDescriptorProto.ADAPTER)
            },
        nested_type = value.nested_type.also { Internal.redactElements(it, DescriptorProto.ADAPTER)
            },
        enum_type = value.enum_type.also { Internal.redactElements(it, EnumDescriptorProto.ADAPTER)
            },
        extension_range = value.extension_range.also { Internal.redactElements(it,
            ExtensionRange.ADAPTER) },
        oneof_decl = value.oneof_decl.also { Internal.redactElements(it,
            OneofDescriptorProto.ADAPTER) },
        options = value.options?.let(MessageOptions.ADAPTER::redact),
        reserved_range = value.reserved_range.also { Internal.redactElements(it,
            ReservedRange.ADAPTER) },
        unknownFields = ByteString.EMPTY
      )
    }
  }

  data class ExtensionRange(
    @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#INT32") val start: Int? =
        null,
    @field:WireField(tag = 2, adapter = "com.squareup.wire.ProtoAdapter#INT32") val end: Int? =
        null,
    @field:WireField(tag = 3, adapter = "com.google.protobuf.ExtensionRangeOptions#ADAPTER")
        val options: ExtensionRangeOptions? = null,
    val unknownFields: ByteString = ByteString.EMPTY
  ) : Message<ExtensionRange, ExtensionRange.Builder>(ADAPTER, unknownFields) {
    @Deprecated(
        message = "Shouldn't be used in Kotlin",
        level = DeprecationLevel.HIDDEN
    )
    override fun newBuilder(): Builder = Builder(this.copy())

    class Builder(private val message: ExtensionRange) : Message.Builder<ExtensionRange, Builder>()
        {
      override fun build(): ExtensionRange = message
    }

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<ExtensionRange> = object : ProtoAdapter<ExtensionRange>(
        FieldEncoding.LENGTH_DELIMITED, 
        ExtensionRange::class.java
      ) {
        override fun encodedSize(value: ExtensionRange): Int = 
          ProtoAdapter.INT32.encodedSizeWithTag(1, value.start) +
          ProtoAdapter.INT32.encodedSizeWithTag(2, value.end) +
          ExtensionRangeOptions.ADAPTER.encodedSizeWithTag(3, value.options) +
          value.unknownFields.size

        override fun encode(writer: ProtoWriter, value: ExtensionRange) {
          ProtoAdapter.INT32.encodeWithTag(writer, 1, value.start)
          ProtoAdapter.INT32.encodeWithTag(writer, 2, value.end)
          ExtensionRangeOptions.ADAPTER.encodeWithTag(writer, 3, value.options)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): ExtensionRange {
          var start: Int? = null
          var end: Int? = null
          var options: ExtensionRangeOptions? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> start = ProtoAdapter.INT32.decode(reader)
              2 -> end = ProtoAdapter.INT32.decode(reader)
              3 -> options = ExtensionRangeOptions.ADAPTER.decode(reader)
              else -> TagHandler.UNKNOWN_TAG
            }
          }
          return ExtensionRange(
            start = start,
            end = end,
            options = options,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: ExtensionRange): ExtensionRange? = value.copy(
          options = value.options?.let(ExtensionRangeOptions.ADAPTER::redact),
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }

  /**
   * Range of reserved tag numbers. Reserved tag numbers may not be used by
   * fields or extension ranges in the same message. Reserved ranges may
   * not overlap.
   */
  data class ReservedRange(
    /**
     * Inclusive.
     */
    @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#INT32") val start: Int? =
        null,
    /**
     * Exclusive.
     */
    @field:WireField(tag = 2, adapter = "com.squareup.wire.ProtoAdapter#INT32") val end: Int? =
        null,
    val unknownFields: ByteString = ByteString.EMPTY
  ) : Message<ReservedRange, ReservedRange.Builder>(ADAPTER, unknownFields) {
    @Deprecated(
        message = "Shouldn't be used in Kotlin",
        level = DeprecationLevel.HIDDEN
    )
    override fun newBuilder(): Builder = Builder(this.copy())

    class Builder(private val message: ReservedRange) : Message.Builder<ReservedRange, Builder>() {
      override fun build(): ReservedRange = message
    }

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<ReservedRange> = object : ProtoAdapter<ReservedRange>(
        FieldEncoding.LENGTH_DELIMITED, 
        ReservedRange::class.java
      ) {
        override fun encodedSize(value: ReservedRange): Int = 
          ProtoAdapter.INT32.encodedSizeWithTag(1, value.start) +
          ProtoAdapter.INT32.encodedSizeWithTag(2, value.end) +
          value.unknownFields.size

        override fun encode(writer: ProtoWriter, value: ReservedRange) {
          ProtoAdapter.INT32.encodeWithTag(writer, 1, value.start)
          ProtoAdapter.INT32.encodeWithTag(writer, 2, value.end)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): ReservedRange {
          var start: Int? = null
          var end: Int? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> start = ProtoAdapter.INT32.decode(reader)
              2 -> end = ProtoAdapter.INT32.decode(reader)
              else -> TagHandler.UNKNOWN_TAG
            }
          }
          return ReservedRange(
            start = start,
            end = end,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: ReservedRange): ReservedRange? = value.copy(
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }
}
