package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) throws IOException {

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("You haven't selected an archive file or you have selected the wrong file.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("An error has occurred. Check the entered data.");
            }

        } while (operation != Operation.EXIT);
    }


    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Select operation:");
        ConsoleHelper.writeMessage(String.format("\t %d - zip the file", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - add the file in archive", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - delete file from archive", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - unpack zip", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - check archives content", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - exit", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}