import org.junit.Test;
import org.testng.Assert;

import java.util.Date;
import java.util.HashMap;

public class BotTest {

    @Test
    public void reply_txt() {
        Bot bot = new Bot();
        Assert.assertEquals(bot.reply("Питание", "10"), "Я родился!");
        Assert.assertEquals(bot.reply("Питание", "10"), "Сейчас я буду кушать, сейчас меня покормят!");
        Assert.assertEquals(bot.reply("Сон", "10"), "Я ложусь спать, не беспокой меня несколько минут!");
        Assert.assertEquals(bot.reply("Туалет", "10"), "Секундочку, я отлучусь...");
        Assert.assertEquals(bot.reply("Счастье", "10"), "Я так рад, что ты у меня есть!");
        Assert.assertEquals(bot.reply("Гигиена", "10"), "А сейчас я хочу расслабиться и принять ванну");
        Assert.assertEquals(bot.reply("Трататата", "10"), "Я не знаю такой команды! Если хочешь узнать список доступных, введи \"Команды\"");
        Assert.assertEquals(bot.reply("Счастье", "15"), "Я родился!");
    }
    @Test
    public void reply_creater() {
        Bot bot = new Bot();
        Bot expected = new Bot();
        Pet pet = new Pet();
        bot.reply("Счастье", "20");
        expected.setTamagochyMap("20", pet);
        Assert.assertEquals(bot.getTamagochyMap().size(), expected.getTamagochyMap().size());

        pet.Down("Питание", 50);
        bot.setTamagochyMap("20", pet);
        String expectStates = "Сон: 100 || Счастье: 100 || Гигиена: 100 || Питание: 50 || Туалет: 100 || ";
        Assert.assertEquals(bot.reply("Проверка", "20"), expectStates);

    }
    @Test
    public void getDeathCount_test() {
        Date currentDate = new Date();
        Bot bot = new Bot();
        int count = bot.getDeathCount(currentDate);
        Assert.assertEquals(count, 0);

        currentDate = new Date();
        Date testDate = new Date(currentDate.getTime() + 7000);
        count = bot.getDeathCount(testDate);
        Assert.assertEquals(count, 0);

        currentDate = new Date();
        testDate = new Date(currentDate.getTime() + 20000);
        count = bot.getDeathCount(testDate);
        Assert.assertEquals(count, 2);

    }
}