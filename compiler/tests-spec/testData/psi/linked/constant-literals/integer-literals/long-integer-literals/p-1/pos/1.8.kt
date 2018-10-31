/*
 * KOTLIN PSI SPEC TEST (POSITIVE)
 *
 * SECTIONS: constant-literals, integer-literals, long-integer-literals
 * PARAGRAPH: 1
 * SENTENCE: [1] Any of the decimal, hexadecimal or binary literals may be suffixed by the long literal mark (symbol L).
 * NUMBER: 8
 * DESCRIPTION: Binary integer literals with underscores suffixed by the long literal mark.
 */

val value = 0b0_00_01_11_11_00_00L
val value = 0B0_1_0_1_0_1_0_1_0_1_0_1L
val value = 0b101_010_10101L
val value = 0B00000000000________________________0L
val value = 0b0_0L
val value = 0B00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000_00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000L
val value = 0B11111111111111111111111111_________1111111111111111111111111111111111111L
val value = 0b1_______________________________________________________________________________________________________________________________________________________0L

val value = 0b_000111010001111L
val value = 0b_______011001L
val value = 0B_0_1_0_1_1_0_0L
val value = 0b_L

val value = 0b0_1_0_1_0_1_____L
val value = 0B1_______0_______1_______0_L
val value = 0B000000000_L
val value = 0b_L
val value = 0B______________L
val value = 0B0_L
val value = 0b10_L
