import telebot

bot = telebot.TeleBot("6655512770:AAGwjeb27wwiqW_LDtvAEDwm5nJ9wjoQOqM")

@bot.message_handler(func = lambda message : True)
def send_welcome(message):
	bot.reply_to(message, "qq ceis tão fazeno?")
	
bot.polling()
