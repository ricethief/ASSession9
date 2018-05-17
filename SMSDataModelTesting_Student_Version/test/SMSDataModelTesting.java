
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 001047904
 */
public class SMSDataModelTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Adding phone number
        try {

            // TODO code application logic here
            SMSDataModelArray smsDataModelArray1;
            smsDataModelArray1 = new SMSDataModelArray();

            smsDataModelArray1.addPhoneNumber("123456");

            System.out.println("Testing [adding PhoneNumber] ->" + smsDataModelArray1);

            //MexphoneNumber setting
            System.out.println("*---------------------ARRAY TESTING------------------------*");
            SMSDataModelArray smsDataModelArray2;
            smsDataModelArray2 = new SMSDataModelArray("Setting mex phone number to 2", 2);

            System.out.println("Testing [Max PhoneNumber] ->" + smsDataModelArray2);

            //Find phone number Index
            System.out.println("*---------------------------------------------*");
            smsDataModelArray2.addPhoneNumber("123456");
            smsDataModelArray2.addPhoneNumber("654321");

            System.out.println(smsDataModelArray2);
            System.out.println("Testing [find PhoneNumber 654321's Index] ->" + smsDataModelArray2.findPhoneNumberIndex("654321"));
            System.out.println("Testing [find PhoneNumber 123456's Index] ->" + smsDataModelArray2.findPhoneNumberIndex("123456"));

            //Update phone number
            System.out.println("*---------------------------------------------*");
            SMSDataModelArray smsDataModelArray3;
            smsDataModelArray3 = new SMSDataModelArray("MaxPN 1", 1);
            smsDataModelArray3.addPhoneNumber("before update");
            System.out.println("Testing [updatePhoneNumber before] ->" + smsDataModelArray3);

            smsDataModelArray3.updatePhoneNumber("after update", 0);
            System.out.println("Testing [updatePhoneNumber after] ->" + smsDataModelArray3);

            //Get phone number
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getPhoneNumber at array 0] ->" + smsDataModelArray2.getPhoneNumber(0));
            System.out.println("Testing [getPhoneNumber at array 1] ->" + smsDataModelArray2.getPhoneNumber(1));
            System.out.println("Testing [getPhoneNumber at array 2] ->" + smsDataModelArray2.getPhoneNumber(2));

            //delete number
            System.out.println("*---------------------------------------------*");
            String phoneNumberdeleted;
            System.out.println("Testing [deleteNumber brfore deletion] ->" + smsDataModelArray2);
            phoneNumberdeleted = smsDataModelArray2.deleteNumber(0);
            System.out.println("Testing [deleteNumber at array 0] ->" + phoneNumberdeleted);
            System.out.println("Testing [deleteNumber at array 0] ->" + smsDataModelArray2);
            phoneNumberdeleted = smsDataModelArray2.deleteNumber(0);
            System.out.println("Testing [deleteNumber at array 1] ->" + phoneNumberdeleted);
            System.out.println("Testing [deleteNumber at array 1] ->" + smsDataModelArray2);
            phoneNumberdeleted = smsDataModelArray2.deleteNumber(1);
            System.out.println("Testing [deleteNumber at array 2 expecting Null] ->" + phoneNumberdeleted);
            System.out.println("Testing [deleteNumber at array 2] ->" + smsDataModelArray2);

            //getMaxNumPhonenumbers
            System.out.println("*---------------------------------------------*");
            SMSDataModelArray smsDataModelArray4;
            smsDataModelArray4 = new SMSDataModelArray("maxis7", 7);
            System.out.println("Testing [getphoneMaxNumber, expecting 7] ->" + smsDataModelArray4.getMaxNumPhoneNumbers());

            //is full
            System.out.println("*---------------------------------------------*");
            smsDataModelArray4.addPhoneNumber("11224456");
            smsDataModelArray4.addPhoneNumber("16224456");
            smsDataModelArray4.addPhoneNumber("14224456");
            smsDataModelArray4.addPhoneNumber("91224456");
            smsDataModelArray4.addPhoneNumber("81224456");
            smsDataModelArray4.addPhoneNumber("71224456");
            smsDataModelArray4.addPhoneNumber("51224456");
            String answer = "";
            if (smsDataModelArray4.isFull() == true) {
                answer = "Full";
            } else {
                answer = "No Full";
            }
            System.out.println("Testing [isfull, expecting Full] ->" + answer);

            //getPhoneNumbers
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getphoneNumbers] ->" + Arrays.toString(smsDataModelArray4.getPhoneNumbers()));

            //get num phonNumbers
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getphoneMaxNumber, expecting 7] ->" + smsDataModelArray4.getNumPhoneNumbers());

            //getMessage
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getMessage, expecting maxis7] ->" + smsDataModelArray4.getMessage());

            //setMessage
            System.out.println("*---------------------------------------------*");
            smsDataModelArray4.setMessage("SetMessage Done");
            System.out.println("Testing [setMessage, expecting maxis7] ->" + smsDataModelArray4.getMessage());

            //testing sorting
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [Before sorting, expecting maxis7] ->" + smsDataModelArray4);
            smsDataModelArray4.sortNumbers();
            System.out.println("Testing [After sorting, expecting maxis7] ->" + smsDataModelArray4);
        } catch (SMSDataModelFullException ex) {
            Logger.getLogger(SMSDataModelTesting.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            System.out.println("\n" + "*--------------------LIST TESTING-------------------------*");
            SMSDataModelList smsDataModelList1;
            smsDataModelList1 = new SMSDataModelList("message", 5);
            //Add Phone Number
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [Add phone Number before]->" + smsDataModelList1);
            smsDataModelList1.addPhoneNumber("1333");
            smsDataModelList1.addPhoneNumber("12663");
            smsDataModelList1.addPhoneNumber("76663");
            smsDataModelList1.addPhoneNumber("82663");
            smsDataModelList1.addPhoneNumber("62123");
            System.out.println("Testing [Add phone Number before]->" + smsDataModelList1);

            //findPhoneNumberIndex
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [findPhoneNumberIndex, expecting 2]->" + smsDataModelList1.findPhoneNumberIndex("76663"));

            //updatePhoneNumber
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [updatePhoneNumber before update]->" + smsDataModelList1);
            smsDataModelList1.updatePhoneNumber("1333", 1);
            System.out.println("Testing [updatePhoneNumber after update]->" + smsDataModelList1);

            //getPhoneNumber
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getPhoneNumber, expecting 76663]->" + smsDataModelList1.getPhoneNumber(2));

            //deleteNumber
            System.out.println("Testing [updatePhoneNumber before Delete index0]->" + smsDataModelList1);
            smsDataModelList1.deleteNumber(0);
            System.out.println("Testing [updatePhoneNumber after Delete index0]->" + smsDataModelList1);

            //getMaxNumPhoneNumbers
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getMaxPhoneNumbers, expecting 5]->" + smsDataModelList1.getMaxNumPhoneNumbers());

            //isFull
            System.out.println("*---------------------------------------------*");
            String answer = "";
            if (smsDataModelList1.isFull() == true) {
                answer = "Full";
            } else {
                answer = "Not Full";
            }
            System.out.println("Testing [isfull, expecting Not Full] ->" + answer);

            //getPhoneNumbers
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getPhoneNumbers]->" + Arrays.toString(smsDataModelList1.getPhoneNumbers()));

            //getNumPhoneNumbers
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getNumPhoneNumbers, expecting 4]->" + smsDataModelList1.getNumPhoneNumbers());

            //get Message
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [getMessage]->" + smsDataModelList1.getMessage());

            //set Message
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [set message before]->" + smsDataModelList1.getMessage());
            smsDataModelList1.setMessage("this message has Edited");
            System.out.println("Testing [set message after]->" + smsDataModelList1.getMessage());

            //sort number
            System.out.println("*---------------------------------------------*");
            System.out.println("Testing [sort numbers before]->" + smsDataModelList1);
            smsDataModelList1.sortNumbers();
            System.out.println("Testing [sort numbers after]->" + smsDataModelList1);

        } catch (SMSDataModelFullException ex) {
            Logger.getLogger(SMSDataModelTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
