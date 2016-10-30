package com.example.jonelezhang.contactmanager;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;

import static android.os.Environment.DIRECTORY_DOCUMENTS;

/**
 * Created by Shadow on 10/29/16.
 */

public class FileManager {

    private static final FileManager INSTANCE = new FileManager();

    private FileManager() {}

    public static FileManager getInstance() {
        return INSTANCE;
    }

    private File persistence() {
        File root = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOCUMENTS);
        File dir = new File(root.getAbsolutePath() + File.separator + "ContactManager");
        File file = new File(dir, "db.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public void saveToPersistence(Collection<Contact> contacts) {
        File file = persistence();
        try {
            FileOutputStream f = new FileOutputStream(file,false); //True = Append to file, false = Overwrite
            PrintStream p = new PrintStream(f);

            for (Contact contact: contacts) {
                String line = contact.getId() + '\t' +
                        contact.getFirstName() + '\t' +
                        contact.getLastName() + '\t' +
                        contact.getPhoneNumber() + '\t' +
                        contact.getEmail() + '\t';
                p.print(line);
                p.print('\n');
            }

            p.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<Contact> readFromPersistence() {

        HashSet<Contact> contacts = new HashSet<>();

        File file = persistence();
        try {
            FileInputStream f = new FileInputStream(file); //True = Append to file, false = Overwrite

            BufferedReader reader = new BufferedReader(new InputStreamReader(f));

            String line = reader.readLine();
            while (line != null) {

                String[] fields = line.split("\t");
                line = reader.readLine();
                if (fields.length < 2) { continue; }

                Contact contact = new Contact();
                contact.setId(fields[0]);
                contact.setFirstName(fields[1]);
                if (fields.length > 2) { contact.setLastName(fields[2]); }
                if (fields.length > 3) { contact.setPhoneNumber(fields[3]); }
                if (fields.length > 4) { contact.setEmail(fields[4]); }

                contacts.add(contact);
            }

            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

}
