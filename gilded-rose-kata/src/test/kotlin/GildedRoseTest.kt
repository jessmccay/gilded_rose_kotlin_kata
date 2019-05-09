import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*


class GildedRoseTest {

    @Test
    internal fun `Test Aged Brie`() {
        val quality = 10
        val newCheese = Item("Aged Brie", 10, quality)
        val agingCheese = Item("Aged Brie", 1, quality)
        val expiredCheese = Item("Aged Brie", 0, quality)
        val items = Arrays.asList(newCheese, agingCheese, expiredCheese)
        val gildedRose = GildedRose(items)
        gildedRose.updateQuality()

        assertUpdateOn(newCheese, 9, quality + 1)
        assertUpdateOn(agingCheese, 0, quality + 1)
        assertUpdateOn(expiredCheese, -1, quality + 2)
    }

    @Test
    internal fun `Test Basic Items`() {
        val quality = 10
        val newBasicItem = Item("huckleberries", 8, quality)


        val expiredBasicItem = Item("bananas", 0, quality)
        val dontTouchThisItem = Item("lettuce", 0, 0)
        val items = Arrays.asList(newBasicItem, expiredBasicItem, dontTouchThisItem)
        val gildedRose = GildedRose(items)
        gildedRose.updateQuality()

        assertUpdateOn(newBasicItem, 7, quality -1)
        assertUpdateOn(expiredBasicItem, -1, quality - 2)
        assertUpdateOn(dontTouchThisItem, -1, 0)

    }

    fun assertUpdateOn(item:Item, sellIn: Int, quality: Int){
        assertEquals(sellIn, item.sellIn)
        assertEquals(quality, item.quality)
    }
}