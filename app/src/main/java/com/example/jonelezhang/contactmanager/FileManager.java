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

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    private FileManager() {}

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public static FileManager getInstance() {
        return INSTANCE;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * @return The file stores contacts information.
     */
    private File persistence() {
        //  Find the storage file directory.
        File root = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOCUMENTS);
        File dir = new File(root.getAbsolutePath() + File.separator + "ContactManager");
        dir.mkdirs();
        File file = new File(dir, "db.txt");
        //  Create a empty if not exists.
        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * @param contacts The collection of contacts to save to persistent storage.
     */
    public void saveToPersistence(Collection<Contact> contacts) {
        File file = persistence();
        try {
            FileOutputStream f = new FileOutputStream(file,false); //True = Append to file, false = Overwrite
            PrintStream p = new PrintStream(f);

            //  Use tab as fields separator.
            for (Contact contact: contacts) {
                String line = contact.getId() + '\t' +
                        contact.getFirstName() + '\t' +
                        contact.getLastName() + '\t' +
                        contact.getPhoneNumber() + '\t' +
                        contact.getEmail() + '\t';
                p.print(line);

                //  Use line break as objects separator.
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

    /**
     * Author: zxq150130 - Zengtai Qi
     * @return A set of contacts that was stored in the persistence storage.
     */
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
                //  Id and firstname must exist, otherwise skip this line.
                if (fields.length < 2) { continue; }
                Contact contact = new Contact();
                contact.setId(fields[0]);
                contact.setFirstName(fields[1]);

                //  If any other fields, save them into contact object.
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
