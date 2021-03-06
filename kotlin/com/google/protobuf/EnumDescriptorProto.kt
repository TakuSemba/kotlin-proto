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
 * Describes an enum type.
 */
data class EnumDescriptorProto(
  @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#STRING") val name: String? =
      null,
  @field:WireField(tag = 2, adapter = "com.google.protobuf.EnumValueDescriptorProto#ADAPTER")
      val value: List<EnumValueDescriptorProto> = emptyList(),
  @field:WireField(tag = 3, adapter = "com.google.protobuf.EnumOptions#ADAPTER") val options:
      EnumOptions? = null,
  /**
   * Range of reserved numeric values. Reserved numeric values may not be used
   * by enum values in the same enum declaration. Reserved ranges may not
   * overlap.
   */
  @field:WireField(tag = 4, adapter =
      "com.google.protobuf.EnumDescriptorProto.EnumReservedRange#ADAPTER") val reserved_range:
      List<EnumReservedRange> = emptyList(),
  /**
   * Reserved enum value names, which may not be reused. A given name may only
   * be reserved once.
   */
  @field:WireField(tag = 5, adapter = "com.squareup.wire.ProtoAdapter#STRING") val reserved_name:
      List<String> = emptyList(),
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<EnumDescriptorProto, EnumDescriptorProto.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: EnumDescriptorProto) : Message.Builder<EnumDescriptorProto,
      Builder>() {
    override fun build(): EnumDescriptorProto = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<EnumDescriptorProto> = object : ProtoAdapter<EnumDescriptorProto>(
      FieldEncoding.LENGTH_DELIMITED, 
      EnumDescriptorProto::class.java
    ) {
      override fun encodedSize(value: EnumDescriptorProto): Int = 
        ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) +
        EnumValueDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, value.value) +
        EnumOptions.ADAPTER.encodedSizeWithTag(3, value.options) +
        EnumReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(4, value.reserved_range) +
        ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, value.reserved_name) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: EnumDescriptorProto) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        EnumValueDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.value)
        EnumOptions.ADAPTER.encodeWithTag(writer, 3, value.options)
        EnumReservedRange.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.reserved_range)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 5, value.reserved_name)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): EnumDescriptorProto {
        var name: String? = null
        val value = mutableListOf<EnumValueDescriptorProto>()
        var options: EnumOptions? = null
        val reserved_range = mutableListOf<EnumReservedRange>()
        val reserved_name = mutableListOf<String>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> value.add(EnumValueDescriptorProto.ADAPTER.decode(reader))
            3 -> options = EnumOptions.ADAPTER.decode(reader)
            4 -> reserved_range.add(EnumReservedRange.ADAPTER.decode(reader))
            5 -> reserved_name.add(ProtoAdapter.STRING.decode(reader))
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return EnumDescriptorProto(
          name = name,
          value = value,
          options = options,
          reserved_range = reserved_range,
          reserved_name = reserved_name,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: EnumDescriptorProto): EnumDescriptorProto? = value.copy(
        value = value.value.also { Internal.redactElements(it, EnumValueDescriptorProto.ADAPTER) },
        options = value.options?.let(EnumOptions.ADAPTER::redact),
        reserved_range = value.reserved_range.also { Internal.redactElements(it,
            EnumReservedRange.ADAPTER) },
        unknownFields = ByteString.EMPTY
      )
    }
  }

  /**
   * Range of reserved numeric values. Reserved values may not be used by
   * entries in the same enum. Reserved ranges may not overlap.
   *
   * Note that this is distinct from DescriptorProto.ReservedRange in that it
   * is inclusive such that it can appropriately represent the entire int32
   * domain.
   */
  data class EnumReservedRange(
    /**
     * Inclusive.
     */
    @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#INT32") val start: Int? =
        null,
    /**
     * Inclusive.
     */
    @field:WireField(tag = 2, adapter = "com.squareup.wire.ProtoAdapter#INT32") val end: Int? =
        null,
    val unknownFields: ByteString = ByteString.EMPTY
  ) : Message<EnumReservedRange, EnumReservedRange.Builder>(ADAPTER, unknownFields) {
    @Deprecated(
        message = "Shouldn't be used in Kotlin",
        level = DeprecationLevel.HIDDEN
    )
    override fun newBuilder(): Builder = Builder(this.copy())

    class Builder(private val message: EnumReservedRange) : Message.Builder<EnumReservedRange,
        Builder>() {
      override fun build(): EnumReservedRange = message
    }

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<EnumReservedRange> = object : ProtoAdapter<EnumReservedRange>(
        FieldEncoding.LENGTH_DELIMITED, 
        EnumReservedRange::class.java
      ) {
        override fun encodedSize(value: EnumReservedRange): Int = 
          ProtoAdapter.INT32.encodedSizeWithTag(1, value.start) +
          ProtoAdapter.INT32.encodedSizeWithTag(2, value.end) +
          value.unknownFields.size

        override fun encode(writer: ProtoWriter, value: EnumReservedRange) {
          ProtoAdapter.INT32.encodeWithTag(writer, 1, value.start)
          ProtoAdapter.INT32.encodeWithTag(writer, 2, value.end)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): EnumReservedRange {
          var start: Int? = null
          var end: Int? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> start = ProtoAdapter.INT32.decode(reader)
              2 -> end = ProtoAdapter.INT32.decode(reader)
              else -> TagHandler.UNKNOWN_TAG
            }
          }
          return EnumReservedRange(
            start = start,
            end = end,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: EnumReservedRange): EnumReservedRange? = value.copy(
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }
}
