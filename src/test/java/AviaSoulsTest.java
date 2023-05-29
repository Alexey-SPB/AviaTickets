import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("МСК", "НСК", 100, 11, 20);//9 часов
    Ticket ticket2 = new Ticket("МСК", "НСК", 150, 7, 15);//8 часов
    Ticket ticket3 = new Ticket("ВКО", "АНД", 400, 5, 15);//10 часов
    Ticket ticket4 = new Ticket("ЕКБ", "КСР", 200, 15, 21);//6 часов
    Ticket ticket5 = new Ticket("МРК", "СПБ", 180, 10, 13);//3 часа
    Ticket ticket6 = new Ticket("КЛГ", "СПБ", 300, 8, 10);//2 часа
    Ticket ticket7 = new Ticket("ЛНД", "НЬЮ", 1000, 8, 23);//15 часов
    Ticket ticket8 = new Ticket("НЬЮ", "БЛН", 1000, 6, 21);//15 часов
    @Test
    void compareToEqually() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Assertions.assertEquals(0, ticket8.compareTo(ticket7));
    }

    @Test
    void compareToLess() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
    }

    @Test
    void compareToMore() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Assertions.assertEquals(1, ticket6.compareTo(ticket5));
    }

    @Test
    public void testSearchSeveral() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = aviaSouls.search("МСК", "НСК");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOne() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.search("ВКО", "АНД");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoMatch() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("СПБ", "БЛН");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testComparatorToLess() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Assertions.assertEquals(-1, timeComparator.compare(ticket2, ticket1));
    }

    @Test
    void testComparatorToMore() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Assertions.assertEquals(1, timeComparator.compare(ticket1, ticket2));
    }

    @Test
    void testComparatorToEqually() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Assertions.assertEquals(0, timeComparator.compare(ticket7, ticket8));
    }

    @Test
    public void testSearchAndSortBySeveral() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("МСК", "НСК", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByOne() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Ticket[] expected = {ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("МРК", "СПБ", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByNoMatch() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("БЛН", "МСК", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}

