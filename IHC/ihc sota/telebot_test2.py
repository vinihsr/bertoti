from telegram.ext import Updater, CommandHandler, MessageHandler, filters
import apiai, json
updater = Updater(token = "6655512770:AAGwjeb27wwiqW_LDtvAEDwm5nJ9wjoQOqM" )
dispatcher = updater.dispatcher

def startCommand(bot, update):
    bot.send_message (chat_id = update.message.chat_id, text = "Hello, let's talk")
def textMessage (bot, update):
    response = "Got your message: " + update.message.text
    bot.send_message (chat_id = update.message.chat_id, text = response)

start_command_handler = CommandHandler ("start", startCommand)
text_message_handler = MessageHandler (filters.text, textMessage)

dispatcher.add_handler (start_command_handler)
dispatcher.add_handler (text_message_handler)

updater.start_polling (clean = True)

updater.idle ()
