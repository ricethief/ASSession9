
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Elec
 */
public class SMSDataModelList implements SMSDataModelInterface, Serializable {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_MAX_NUM_PHONE_NUMBERS = 20;
    public static final String FULL = "FULL";
    public static final String DUPLICATE = "DUPLICATE";

    private String message;         //The SMS message
    private List<String> phoneNumbers; //The collection of phone numbers
    //How many phone numbers there are
    private int maxNumPhoneNumbers; //maxNumber of phone numbers

    public SMSDataModelList(String message) {
        this(message, DEFAULT_MAX_NUM_PHONE_NUMBERS);
    }

    public SMSDataModelList() {
        this("", DEFAULT_MAX_NUM_PHONE_NUMBERS);
    }

    public SMSDataModelList(String initialMessage, int maxNumPhoneNumbers) {
        this.message = initialMessage;
        this.phoneNumbers = new ArrayList<String>();

        this.maxNumPhoneNumbers = maxNumPhoneNumbers;
    }

    public String addPhoneNumber(String newPhoneNumber) throws SMSDataModelFullException {
        String result;

        if (maxNumPhoneNumbers == phoneNumbers.size()) {
            result = FULL;
        } else {
            boolean exist;
            exist = findPhoneNumberIndex(newPhoneNumber) != -1;
            if (exist) {
                result = DUPLICATE;
            } else {
                phoneNumbers.add(phoneNumbers.size(), newPhoneNumber);
                result = newPhoneNumber;
            }
        }
        return result;
    }

    public int findPhoneNumberIndex(String targetNumber) {
        int i = 0;
        for (i = 0; i < this.phoneNumbers.size(); i++) {
            if (this.phoneNumbers.get(i).equals(targetNumber)) {
                return i;
            }
        }
        return -1;
    }

    public String updatePhoneNumber(String newPhoneNumber, int i) {
        String result;

        if (i < 0 || i >= phoneNumbers.size()) {
            result = null;
        } else {
            boolean exist;
            exist = findPhoneNumberIndex(newPhoneNumber) != -1;
            if (exist) {
                result = DUPLICATE;
            } else {
                result = phoneNumbers.get(i);
                phoneNumbers.set(i, newPhoneNumber);
            }
        }
        return result;
    }

    public String getPhoneNumber(int i) {
        String result;

        if (i < 0 || i >= phoneNumbers.size()) {
            result = null;
        } else {
            result = phoneNumbers.get(i);
        }
        return result;
    }

    public String deleteNumber(int i) {
        String result;
        if (i < 0 || i >= phoneNumbers.size()) {
            result = null;
        } else {
            result = phoneNumbers.get(i);
            phoneNumbers.remove(i);

        }
        return result;
    }

    public int getMaxNumPhoneNumbers() {
        return this.maxNumPhoneNumbers;
    }

    public boolean isFull() {
        return phoneNumbers.size() == this.maxNumPhoneNumbers;
    }

    public String[] getPhoneNumbers() {
        String[] phoneNumberArray = phoneNumbers.toArray(new String[0]);
        return phoneNumberArray;
    }

    public int getNumPhoneNumbers() {
        return phoneNumbers.size();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String mMessage) {
        this.message = mMessage;
    }

    public void sortNumbers() {
        Collections.sort(phoneNumbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : phoneNumbers) {
            sb.append(s.toString());
            sb.append(", ");
        }
        return "SMSDataModel [message=" + message + ", phoneNumbers="
                + sb + "]" + "numPhoneNumbers="
                + phoneNumbers.size() + "]";
    }

}
