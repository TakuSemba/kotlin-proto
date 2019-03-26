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
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * A message representing a option the parser does not recognize. This only
 * appears in options protos created by the compiler::Parser class.
 * DescriptorPool resolves these when building Descriptor objects. Therefore,
 * options protos in descriptor objects (e.g. returned by Descriptor::options(),
 * or produced by Descriptor::CopyTo()) will never have UninterpretedOptions
 * in them.
 */
data class UninterpretedOption(
  @field:WireField(tag = 2, adapter = "com.google.protobuf.UninterpretedOption.NamePart#ADAPTER")
      val name: List<NamePart> = emptyList(),
  /**
   * The value of the uninterpreted option, in whatever type the tokenizer
   * identified it as during parsing. Exactly one of these should be set.
   */
  @field:WireField(tag = 3, adapter = "com.squareup.wire.ProtoAdapter#STRING") val identifier_value:
      String? = null,
  @field:WireField(tag = 4, adapter = "com.squareup.wire.ProtoAdapter#UINT64")
      val positive_int_value: Long? = null,
  @field:WireField(tag = 5, adapter = "com.squareup.wire.ProtoAdapter#INT64")
      val negative_int_value: Long? = null,
  @field:WireField(tag = 6, adapter = "com.squareup.wire.ProtoAdapter#DOUBLE") val double_value:
      Double? = null,
  @field:WireField(tag = 7, adapter = "com.squareup.wire.ProtoAdapter#BYTES") val string_value:
      ByteString? = null,
  @field:WireField(tag = 8, adapter = "com.squareup.wire.ProtoAdapter#STRING") val aggregate_value:
      String? = null,
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<UninterpretedOption, UninterpretedOption.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: UninterpretedOption) : Message.Builder<UninterpretedOption,
      Builder>() {
    override fun build(): UninterpretedOption = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<UninterpretedOption> = object : ProtoAdapter<UninterpretedOption>(
      FieldEncoding.LENGTH_DELIMITED, 
      UninterpretedOption::class.java
    ) {
      override fun encodedSize(value: UninterpretedOption): Int = 
        NamePart.ADAPTER.asRepeated().encodedSizeWithTag(2, value.name) +
        ProtoAdapter.STRING.encodedSizeWithTag(3, value.identifier_value) +
        ProtoAdapter.UINT64.encodedSizeWithTag(4, value.positive_int_value) +
        ProtoAdapter.INT64.encodedSizeWithTag(5, value.negative_int_value) +
        ProtoAdapter.DOUBLE.encodedSizeWithTag(6, value.double_value) +
        ProtoAdapter.BYTES.encodedSizeWithTag(7, value.string_value) +
        ProtoAdapter.STRING.encodedSizeWithTag(8, value.aggregate_value) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: UninterpretedOption) {
        NamePart.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.name)
        ProtoAdapter.STRING.encodeWithTag(writer, 3, value.identifier_value)
        ProtoAdapter.UINT64.encodeWithTag(writer, 4, value.positive_int_value)
        ProtoAdapter.INT64.encodeWithTag(writer, 5, value.negative_int_value)
        ProtoAdapter.DOUBLE.encodeWithTag(writer, 6, value.double_value)
        ProtoAdapter.BYTES.encodeWithTag(writer, 7, value.string_value)
        ProtoAdapter.STRING.encodeWithTag(writer, 8, value.aggregate_value)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): UninterpretedOption {
        val name = mutableListOf<NamePart>()
        var identifier_value: String? = null
        var positive_int_value: Long? = null
        var negative_int_value: Long? = null
        var double_value: Double? = null
        var string_value: ByteString? = null
        var aggregate_value: String? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            2 -> name.add(NamePart.ADAPTER.decode(reader))
            3 -> identifier_value = ProtoAdapter.STRING.decode(reader)
            4 -> positive_int_value = ProtoAdapter.UINT64.decode(reader)
            5 -> negative_int_value = ProtoAdapter.INT64.decode(reader)
            6 -> double_value = ProtoAdapter.DOUBLE.decode(reader)
            7 -> string_value = ProtoAdapter.BYTES.decode(reader)
            8 -> aggregate_value = ProtoAdapter.STRING.decode(reader)
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return UninterpretedOption(
          name = name,
          identifier_value = identifier_value,
          positive_int_value = positive_int_value,
          negative_int_value = negative_int_value,
          double_value = double_value,
          string_value = string_value,
          aggregate_value = aggregate_value,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: UninterpretedOption): UninterpretedOption? = value.copy(
        name = value.name.also { Internal.redactElements(it, NamePart.ADAPTER) },
        unknownFields = ByteString.EMPTY
      )
    }
  }

  /**
   * The name of the uninterpreted option.  Each string represents a segment in
   * a dot-separated name.  is_extension is true iff a segment represents an
   * extension (denoted with parentheses in options specs in .proto files).
   * E.g.,{ ["foo", false], ["bar.baz", true], ["qux", false] } represents
   * "foo.(bar.baz).qux".
   */
  data class NamePart(
    @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#STRING") val name_part:
        String,
    @field:WireField(tag = 2, adapter = "com.squareup.wire.ProtoAdapter#BOOL") val is_extension:
        Boolean,
    val unknownFields: ByteString = ByteString.EMPTY
  ) : Message<NamePart, NamePart.Builder>(ADAPTER, unknownFields) {
    @Deprecated(
        message = "Shouldn't be used in Kotlin",
        level = DeprecationLevel.HIDDEN
    )
    override fun newBuilder(): Builder = Builder(this.copy())

    class Builder(private val message: NamePart) : Message.Builder<NamePart, Builder>() {
      override fun build(): NamePart = message
    }

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<NamePart> = object : ProtoAdapter<NamePart>(
        FieldEncoding.LENGTH_DELIMITED, 
        NamePart::class.java
      ) {
        override fun encodedSize(value: NamePart): Int = 
          ProtoAdapter.STRING.encodedSizeWithTag(1, value.name_part) +
          ProtoAdapter.BOOL.encodedSizeWithTag(2, value.is_extension) +
          value.unknownFields.size

        override fun encode(writer: ProtoWriter, value: NamePart) {
          ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name_part)
          ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.is_extension)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): NamePart {
          var name_part: String? = null
          var is_extension: Boolean? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> name_part = ProtoAdapter.STRING.decode(reader)
              2 -> is_extension = ProtoAdapter.BOOL.decode(reader)
              else -> TagHandler.UNKNOWN_TAG
            }
          }
          return NamePart(
            name_part = name_part ?: throw Internal.missingRequiredFields(name_part, "name_part"),
            is_extension = is_extension ?: throw Internal.missingRequiredFields(is_extension,
                "is_extension"),
            unknownFields = unknownFields
          )
        }

        override fun redact(value: NamePart): NamePart? = value.copy(
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }
}
