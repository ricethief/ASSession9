
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
            SMSDataModelArray smsDataModelArray2;
            smsDataModelArray2 = new SMSDataModelArray("Setting mex phone number to 2", 2);

            System.out.println("Testing [Max PhoneNumber] ->" + smsDataModelArray2);

            //Find phone number Index
            smsDataModelArray2.addPhoneNumber("123456");
            smsDataModelArray2.addPhoneNumber("654321");

            System.out.println(smsDataModelArray2);
            System.out.println("Testing [find PhoneNumber 654321's Index] ->" + smsDataModelArray2.findPhoneNumberIndex("654321"));
            System.out.println("Testing [find PhoneNumber 123456's Index] ->" + smsDataModelArray2.findPhoneNumberIndex("123456"));

            //Update phone number
            SMSDataModelArray smsDataModelArray3;
            smsDataModelArray3 = new SMSDataModelArray("MaxPN 1", 1);
            smsDataModelArray3.addPhoneNumber("before update");
            System.out.println("Testing [updatePhoneNumber before] ->" + smsDataModelArray3);

            smsDataModelArray3.updatePhoneNumber("after update", 0);
            System.out.println("Testing [updatePhoneNumber after] ->" + smsDataModelArray3);

            //Get phone number
            System.out.println("Testing [getPhoneNumber at array 0] ->" + smsDataModelArray2.getPhoneNumber(0));
            System.out.println("Testing [getPhoneNumber at array 1] ->" + smsDataModelArray2.getPhoneNumber(1));
            System.out.println("Testing [getPhoneNumber at array 2] ->" + smsDataModelArray2.getPhoneNumber(2));

            //delete number
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

            //
            
        } catch (SMSDataModelFullException ex) {
            Logger.getLogger(SMSDataModelTesting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
