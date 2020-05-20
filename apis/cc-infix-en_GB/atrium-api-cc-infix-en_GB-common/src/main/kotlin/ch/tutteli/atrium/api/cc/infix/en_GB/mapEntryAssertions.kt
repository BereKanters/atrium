// TODO remove file with 1.0.0
@file:Suppress("DEPRECATION", "TYPEALIAS_EXPANSION_DEPRECATION")
package ch.tutteli.atrium.api.cc.infix.en_GB

import ch.tutteli.atrium.assertions.Assertion
import ch.tutteli.atrium.creating.Assert
import ch.tutteli.atrium.creating.AssertionPlant
import ch.tutteli.atrium.creating.AssertionPlantNullable
import ch.tutteli.atrium.creating.SubjectProvider
import ch.tutteli.atrium.domain.builders.AssertImpl

/**
 * Makes the assertion that the [Assert.subject][SubjectProvider.subject]'s [Map.Entry.key] is (equal to) the given [Pair.first] and
 * [Map.Entry.value] is [Pair.second].
 *
 * Kind of a shortcut for `key.toBe(keyValuePair.first); value.toBe(keyValuePair.second)` but should be evaluated in
 * an assertion group block -- which has the effect that the assertion about the value is still evaluated even
 * if the assertion about the key fails. Moreover, it might be that reporting differs compared to using the long form.
 *
 * @return This plant to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
@Deprecated(
    "Switch from Assert to Expect; will be removed with 1.0.0 -- see https://github.com/robstoll/atrium/releases/tag/v0.12.0#migration for migration hints and scripts.",
    ReplaceWith(
        "this.asExpect().isKeyValue(keyValuePair).asAssert()",
        "ch.tutteli.atrium.domain.builders.migration.asExpect",
        "ch.tutteli.atrium.domain.builders.migration.asAssert",
        "ch.tutteli.atrium.api.infix.en_GB.isKeyValue"
    )
)
@Suppress("DEPRECATION")
infix fun <K : Any, V : Any> Assert<Map.Entry<K, V>>.isKeyValue(keyValuePair: Pair<K, V>): Assert<Map.Entry<K, V>>
    = addAssertion(AssertImpl.map.entry.isKeyValue(this, keyValuePair.first, keyValuePair.second))

/**
 * Creates an [AssertionPlant] for the [Assert.subject][SubjectProvider.subject]'s property [key][Map.Entry.key] so that further
 * fluent calls are assertions about it.
 *
 * Wrap it into Kotlin's [apply] if you want to make subsequent assertions on the current subject or use the overload
 * which expects an assertionCreatorOrNull lambda where sub assertions are evaluated together (form an assertion group block).
 *
 * @return The newly created [AssertionPlant].
 */
@Deprecated(
    "Switch from Assert to Expect; will be removed with 1.0.0 -- see https://github.com/robstoll/atrium/releases/tag/v0.12.0#migration for migration hints and scripts.",
    ReplaceWith(
        "this.asExpect().key",
        "ch.tutteli.atrium.domain.builders.migration.asExpect",
        "ch.tutteli.atrium.api.infix.en_GB.key"
    )
)
val <K : Any> Assert<Map.Entry<K, *>>.key get() : Assert<K> = property(Map.Entry<K, *>::key)

/**
 * Creates an [AssertionPlant] for the [Assert.subject][SubjectProvider.subject]'s property [key][Map.Entry.key] (which could be `null`)
 * so that further fluent calls are assertions about it.
 *
 * Wrap it into Kotlin's [apply] if you want to make subsequent assertions on the current subject or use the overload
 * which expects an assertionCreatorOrNull lambda where sub assertions are evaluated together (form an assertion group block).
 *
 * @return The newly created [AssertionPlant].
 */
//TODO deprecate as soon as https://youtrack.jetbrains.com/issue/KT-33398 is fixed
//@Deprecated(
//    "Switch from Assert to Expect; will be removed with 1.0.0 -- see https://github.com/robstoll/atrium/releases/tag/v0.12.0#migration for migration hints and scripts.",
//    ReplaceWith(
//        "this.asExpect().key",
//        "ch.tutteli.atrium.domain.builders.migration.asExpect",
//        "ch.tutteli.atrium.api.infix.en_GB.key"
//    )
//)
val <K> Assert<Map.Entry<K, *>>.key get() : AssertionPlantNullable<K> = property(Map.Entry<K, *>::key)

/**
 * Makes the assertion that the [Assert.subject][SubjectProvider.subject]'s property [key][Map.Entry.key] holds all assertions the given
 * [assertionCreator] might create for it.
 *
 * @return This plant to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if a created [Assertion]s (by calling [assertionCreator])
 *   does not hold.
 * @throws IllegalArgumentException in case the given [assertionCreator] did not create a single assertion.
 */
@Suppress("DEPRECATION")
@Deprecated(
    "Switch from Assert to Expect; will be removed with 1.0.0 -- see https://github.com/robstoll/atrium/releases/tag/v0.12.0#migration for migration hints and scripts.",
    ReplaceWith(
        "this.asExpect().apply { key.asAssert(assertionCreator) }.asAssert()",
        "ch.tutteli.atrium.domain.builders.migration.asExpect",
        "ch.tutteli.atrium.domain.builders.migration.asAssert",
        "ch.tutteli.atrium.api.infix.en_GB.key"
    )
)
infix fun <K : Any, V> Assert<Map.Entry<K, V>>.key(assertionCreator: Assert<K>.() -> Unit)
    = addAssertion(AssertImpl.map.entry.key(this, assertionCreator))


/**
 * Creates an [AssertionPlant] for the [Assert.subject][SubjectProvider.subject]'s property [value][Map.Entry.value] so that further
 * fluent calls are assertions about it.
 *
 * Wrap it into Kotlin's [apply] if you want to make subsequent assertions on the current subject or use the overload
 * which expects an assertionCreatorOrNull lambda where sub assertions are evaluated together (form an assertion group block).
 *
 * @return The newly created [AssertionPlant].
 */
@Deprecated(
    "Switch from Assert to Expect; will be removed with 1.0.0 -- see https://github.com/robstoll/atrium/releases/tag/v0.12.0#migration for migration hints and scripts.",
    ReplaceWith(
        "this.asExpect().value",
        "ch.tutteli.atrium.domain.builders.migration.asExpect",
        "ch.tutteli.atrium.api.infix.en_GB.value"
    )
)
val <V : Any> Assert<Map.Entry<*, V>>.value get() : Assert<V> = property(Map.Entry<*, V>::value)

/**
 * Creates an [AssertionPlant] for the [Assert.subject][SubjectProvider.subject]'s property [value][Map.Entry.value]
 * (which could be `null`) so that further fluent calls are assertions about it.
 *
 * Wrap it into Kotlin's [apply] if you want to make subsequent assertions on the current subject or use the overload
 * which expects an assertionCreatorOrNull lambda where sub assertions are evaluated together (form an assertion group block).
 *
 * @return The newly created [AssertionPlant].
 */
//TODO deprecate as soon as https://youtrack.jetbrains.com/issue/KT-33398 is fixed
//@Deprecated(
//    "Switch from Assert to Expect; will be removed with 1.0.0 -- see https://github.com/robstoll/atrium/releases/tag/v0.12.0#migration for migration hints and scripts.",
//    ReplaceWith(
//        "this.asExpect().value",
//        "ch.tutteli.atrium.domain.builders.migration.asExpect",
//        "ch.tutteli.atrium.api.infix.en_GB.value"
//    )
//)
val <V> Assert<Map.Entry<*, V>>.value get() : AssertionPlantNullable<V> = property(Map.Entry<*, V>::value)

/**
 * Makes the assertion that the [Assert.subject][SubjectProvider.subject]'s property [value][Map.Entry.value] holds all assertions the given
 * [assertionCreator] might create for it.
 *
 * @return This plant to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if a created [Assertion]s (by calling [assertionCreator])
 *   does not hold.
 * @throws IllegalArgumentException in case the given [assertionCreator] did not create a single assertion.
 */
@Deprecated(
    "Switch from Assert to Expect; will be removed with 1.0.0 -- see https://github.com/robstoll/atrium/releases/tag/v0.12.0#migration for migration hints and scripts.",
    ReplaceWith(
        "this.asExpect().apply { value.asAssert(assertionCreator) }.asAssert()",
        "ch.tutteli.atrium.domain.builders.migration.asExpect",
        "ch.tutteli.atrium.domain.builders.migration.asAssert",
        "ch.tutteli.atrium.api.infix.en_GB.value"
    )
)
@Suppress("DEPRECATION")
infix fun <K, V: Any> Assert<Map.Entry<K, V>>.value(assertionCreator: Assert<V>.() -> Unit)
    = addAssertion(AssertImpl.map.entry.value(this, assertionCreator))
