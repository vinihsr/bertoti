import telebot
from pandasai import SmartDataframe as pd

bot = telebot.TeleBot("6655512770:AAGwjeb27wwiqW_LDtvAEDwm5nJ9wjoQOqM")

df = pd.DataFrame({
    "country": [
        "United States", "United Kingdom", "France", "Germany", "Italy", "Spain", "Canada", "Australia", "Japan", "China"],
    "gdp": [
        19294482071552, 2891615567872, 2411255037952, 3435817336832, 1745433788416, 1181205135360, 1607402389504, 1490967855104, 4380756541440, 14631844184064
    ],
})

@bot.message_handler(func = lambda message : True)
def send_welcome(message):
	df = pd(df)
	resposta = df.chat('Which are the countries with GDP greater than 3000000000000?')
	bot.reply_to(message, resposta)


bot.polling()