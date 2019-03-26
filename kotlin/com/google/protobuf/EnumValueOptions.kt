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
import kotlin.Int
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

data class EnumValueOptions(
  /**
   * Is this enum value deprecated?
   * Depending on the target platform, this can emit Deprecated annotations
   * for the enum value, or it will be completely ignored; in the very least,
   * this is a formalization for deprecating enum values.
   */
  @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#BOOL") val deprecated:
      Boolean? = false,
  /**
   * The parser stores options it doesn't recognize here. See above.
   */
  @field:WireField(tag = 999, adapter = "com.google.protobuf.UninterpretedOption#ADAPTER")
      val uninterpreted_option: List<UninterpretedOption> = emptyList(),
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<EnumValueOptions, EnumValueOptions.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: EnumValueOptions) : Message.Builder<EnumValueOptions,
      Builder>() {
    override fun build(): EnumValueOptions = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<EnumValueOptions> = object : ProtoAdapter<EnumValueOptions>(
      FieldEncoding.LENGTH_DELIMITED, 
      EnumValueOptions::class.java
    ) {
      override fun encodedSize(value: EnumValueOptions): Int = 
        ProtoAdapter.BOOL.encodedSizeWithTag(1, value.deprecated) +
        UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999,
            value.uninterpreted_option) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: EnumValueOptions) {
        ProtoAdapter.BOOL.encodeWithTag(writer, 1, value.deprecated)
        UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(writer, 999,
            value.uninterpreted_option)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): EnumValueOptions {
        var deprecated: Boolean = false
        val uninterpreted_option = mutableListOf<UninterpretedOption>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> deprecated = ProtoAdapter.BOOL.decode(reader)
            999 -> uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(reader))
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return EnumValueOptions(
          deprecated = deprecated,
          uninterpreted_option = uninterpreted_option,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: EnumValueOptions): EnumValueOptions? = value.copy(
        uninterpreted_option = value.uninterpreted_option.also { Internal.redactElements(it,
            UninterpretedOption.ADAPTER) },
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
