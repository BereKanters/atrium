package ch.tutteli.atrium.api.infix.en_GB

import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.logic.creating.typeutils.MapLike
import ch.tutteli.atrium.specs.*
import ch.tutteli.atrium.specs.integration.mfun2
import org.spekframework.spek2.Spek
import kotlin.jvm.JvmName
import ch.tutteli.atrium.api.infix.en_GB.MapContainsInAnyOrderEntriesOfAssertionsSpec.Companion as C

class MapContainsInAnyOrderEntriesOfAssertionsSpec : Spek({
    include(BuilderSpec)
    include(ShortcutSpec)
    include(BuilderMapLikeToIterablePairSpec)
    include(ShortcutMapLikeToIterablePairSpec)
}) {
    object BuilderSpec : ch.tutteli.atrium.specs.integration.MapContainsInAnyOrderKeyValuePairsAssertionsSpec(
        containsKeyValuePair_s to C::containsKeyValuePairs,
        (containsKeyValuePair_s to C::containsKeyValuePairsNullable).withNullableSuffix(),
        "[Atrium][Shortcut] "
    )

    object ShortcutSpec : ch.tutteli.atrium.specs.integration.MapContainsInAnyOrderKeyValuePairsAssertionsSpec(
        mfun2<String, Int, Int>(C::containsEntriesOf),
        mfun2<String?, Int?, Int?>(C::containsEntriesOf).withNullableSuffix(),
        "[Atrium][Shortcut] "
    )

    object BuilderMapLikeToIterablePairSpec :
        ch.tutteli.atrium.specs.integration.MapLikeToIterablePairSpec<Map<String, Int>>(
            "$contains $filler $inAnyOrder $entriesOf",
            mapOf("a" to 1),
            { input -> it contains o inAny order entriesOf input }
        )

    object ShortcutMapLikeToIterablePairSpec :
        ch.tutteli.atrium.specs.integration.MapLikeToIterablePairSpec<Map<String, Int>>(
            "$containsEntriesOf",
            mapOf("a" to 1),
            { input -> it containsOnlyEntriesOf  input }
        )

    companion object : MapContainsSpecBase() {
        val containsKeyValuePair_s = "$contains $filler $inAnyOrder $entriesOf"

        private fun containsKeyValuePairs(
            expect: Expect<Map<out String, Int>>,
            a: Pair<String, Int>,
            aX: Array<out Pair<String, Int>>
        ): Expect<Map<out String, Int>> {
            val mapLike: MapLike = if (aX.distinct().size != aX.size || aX.contains(a)) {
                sequenceOf(a, *aX).asIterable()
            } else {
                mapOf(a, *aX)
            }
            return expect contains o inAny order entriesOf mapLike
        }

        private fun containsKeyValuePairsNullable(
            expect: Expect<Map<out String?, Int?>>,
            a: Pair<String?, Int?>,
            aX: Array<out Pair<String?, Int?>>
        ): Expect<Map<out String?, Int?>> =
            expect contains o inAny order entriesOf listOf(a, *aX)

        private fun containsEntriesOf(
            expect: Expect<Map<out String, Int>>,
            a: Pair<String, Int>,
            aX: Array<out Pair<String, Int>>
        ): Expect<Map<out String, Int>> =
            expect containsEntriesOf sequenceOf(a, *aX)

        @JvmName("containsEntriesOfNullable")
        private fun containsEntriesOf(
            expect: Expect<Map<out String?, Int?>>,
            a: Pair<String?, Int?>,
            aX: Array<out Pair<String?, Int?>>
        ): Expect<Map<out String?, Int?>> =
            expect containsEntriesOf arrayOf(a, *aX)
    }

    @Suppress("unused", "UNUSED_VALUE")
    private fun ambiguityTest() {
        var map: Expect<Map<Number, CharSequence>> = notImplemented()
        var subMap: Expect<LinkedHashMap<out Number, String>> = notImplemented()
        var nKeyMap: Expect<Map<Number?, CharSequence>> = notImplemented()
        var nValueMap: Expect<Map<Number, CharSequence?>> = notImplemented()
        var nKeyValueMap: Expect<Map<Number?, CharSequence?>> = notImplemented()
        var ronKeyValueMap: Expect<Map<out Number?, CharSequence?>> = notImplemented()
        var starMap: Expect<Map<*, *>> = notImplemented()

        map = map contains o inAny order entriesOf listOf(1 to "a")
        subMap = subMap contains o inAny order entriesOf listOf(1 to "a")
        nKeyMap = nKeyMap contains o inAny order entriesOf listOf(1 to "a")
        nValueMap = nValueMap contains o inAny order entriesOf listOf(1 to "a")
        nKeyValueMap = nKeyValueMap contains o inAny order entriesOf listOf(1 to "a")
        ronKeyValueMap = ronKeyValueMap contains o inAny order entriesOf listOf(1 to "a")
        starMap = starMap contains o inAny order entriesOf listOf(1 to "a")

        map = map containsEntriesOf listOf(1 to "a")
        subMap = subMap containsEntriesOf listOf(1 to "a")
        nKeyMap = nKeyMap containsEntriesOf listOf(1 to "a")
        nValueMap = nValueMap containsEntriesOf listOf(1 to "a")
        nKeyValueMap = nKeyValueMap containsEntriesOf listOf(1 to "a")
        ronKeyValueMap = ronKeyValueMap containsEntriesOf listOf(1 to "a")
        starMap = starMap containsEntriesOf listOf(1 to "a")
    }
}
