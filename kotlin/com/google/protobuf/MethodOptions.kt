// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.TagHandler
import com.squareup.wire.WireEnum
import com.squareup.wire.WireField
import com.squareup.wire.internal.Internal
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import okio.ByteString

data class MethodOptions(
  /**
   * Note:  Field numbers 1 through 32 are reserved for Google's internal RPC
   *   framework.  We apologize for hoarding these numbers to ourselves, but
   *   we were already using them long before we decided to release Protocol
   *   Buffers.
   * Is this method deprecated?
   * Depending on the target platform, this can emit Deprecated annotations
   * for the method, or it will be completely ignored; in the very least,
   * this is a formalization for deprecating methods.
   */
  @field:WireField(tag = 33, adapter = "com.squareup.wire.ProtoAdapter#BOOL") val deprecated:
      Boolean? = false,
  @field:WireField(tag = 34, adapter = "com.google.protobuf.MethodOptions.IdempotencyLevel#ADAPTER")
      val idempotency_level: IdempotencyLevel? = IdempotencyLevel.IDEMPOTENCY_UNKNOWN,
  /**
   * The parser stores options it doesn't recognize here. See above.
   */
  @field:WireField(tag = 999, adapter = "com.google.protobuf.UninterpretedOption#ADAPTER")
      val uninterpreted_option: List<UninterpretedOption> = emptyList(),
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<MethodOptions, MethodOptions.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: MethodOptions) : Message.Builder<MethodOptions, Builder>() {
    override fun build(): MethodOptions = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<MethodOptions> = object : ProtoAdapter<MethodOptions>(
      FieldEncoding.LENGTH_DELIMITED, 
      MethodOptions::class.java
    ) {
      override fun encodedSize(value: MethodOptions): Int = 
        ProtoAdapter.BOOL.encodedSizeWithTag(33, value.deprecated) +
        IdempotencyLevel.ADAPTER.encodedSizeWithTag(34, value.idempotency_level) +
        UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999,
            value.uninterpreted_option) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: MethodOptions) {
        ProtoAdapter.BOOL.encodeWithTag(writer, 33, value.deprecated)
        IdempotencyLevel.ADAPTER.encodeWithTag(writer, 34, value.idempotency_level)
        UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(writer, 999,
            value.uninterpreted_option)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): MethodOptions {
        var deprecated: Boolean = false
        var idempotency_level: IdempotencyLevel = IdempotencyLevel.IDEMPOTENCY_UNKNOWN
        val uninterpreted_option = mutableListOf<UninterpretedOption>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            33 -> deprecated = ProtoAdapter.BOOL.decode(reader)
            34 -> idempotency_level = IdempotencyLevel.ADAPTER.decode(reader)
            999 -> uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(reader))
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return MethodOptions(
          deprecated = deprecated,
          idempotency_level = idempotency_level,
          uninterpreted_option = uninterpreted_option,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: MethodOptions): MethodOptions? = value.copy(
        uninterpreted_option = value.uninterpreted_option.also { Internal.redactElements(it,
            UninterpretedOption.ADAPTER) },
        unknownFields = ByteString.EMPTY
      )
    }
  }

  /**
   * Is this method side-effect-free (or safe in HTTP parlance), or idempotent,
   * or neither? HTTP based RPC implementation may choose GET verb for safe
   * methods, and PUT verb for idempotent methods instead of the default POST.
   */
  enum class IdempotencyLevel(private val value: Int) : WireEnum {
    IDEMPOTENCY_UNKNOWN(0),

    /**
     * implies idempotent
     */
    NO_SIDE_EFFECTS(1),

    /**
     * idempotent, but may have side effects
     */
    IDEMPOTENT(2);

    override fun getValue(): Int = value

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<IdempotencyLevel> = object : EnumAdapter<IdempotencyLevel>(
        IdempotencyLevel::class.java
      ) {
        override fun fromValue(value: Int): IdempotencyLevel = IdempotencyLevel.fromValue(value)
      }

      @JvmStatic
      fun fromValue(value: Int): IdempotencyLevel = when (value) {
        0 -> IDEMPOTENCY_UNKNOWN
        1 -> NO_SIDE_EFFECTS
        2 -> IDEMPOTENT
        else -> throw IllegalArgumentException("""Unexpected value: $value""")
      }
    }
  }
}
