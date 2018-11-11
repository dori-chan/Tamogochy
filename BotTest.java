import org.junit.Test;
import org.testng.Assert;

import java.util.HashMap;

import static org.junit.Assert.*;

public class BotTest {

    @Test
    public void minus() {
        Assert.assertEquals(Bot.minus("Питание"), 20);
        Assert.assertEquals(Bot.minus("Сон"), 100);
        Assert.assertEquals(Bot.minus("Туалет"), 50);
        Assert.assertEquals(Bot.minus("Счастье"), 10);
        Assert.assertEquals(Bot.minus("Гигиена"), 15);
        Assert.assertEquals(Bot.minus("Тататата"), 0);
    }
    @Test
    public void reply() {
        HashMap<String, Needs> expected = Bot.TamagochyMap;
        Needs needs = new Needs();
        expected.put("10", needs);
        Assert.assertEquals(Bot.reply("Питание", "10"),"Сейчас я буду кушать, сейчас меня покормят!");
        Assert.assertEquals(Bot.reply("Сон", "10"),"Я ложусь спать, не беспокой меня несколько минут!");
        Assert.assertEquals(Bot.reply("Туалет", "10"),"Секундочку, я отлучусь...");
        Assert.assertEquals(Bot.reply("Счастье", "10"),"Я так рад, что ты у меня есть!");
        Assert.assertEquals(Bot.reply("Гигиена", "10"),"А сейчас я хочу расслабиться и принять ванну");
        Assert.assertEquals(Bot.reply("Трататата", "10"),"Я не знаю такой команды! Если хочешь узнать список доступных, введи \"Команды\"");
        Assert.assertEquals(Bot.reply("Счастье", "15"),"Я родился!");
        Bot.reply("Счастье", "15");
        needs = new Needs();
        expected.put("15", needs);
        Assert.assertEquals(Bot.TamagochyMap, expected);
        needs.Down("Питание", 50);
        Bot.TamagochyMap.put("20", needs);
        String expectStates = "Сон: 100 || Счастье: 100 || Гигиена: 100 || Питание: 50 || Туалет: 100 || ";
        Assert.assertEquals(Bot.reply("Проверка", "20"), expectStates);
    }
}