package chap03.main;

import chap03.ChangePasswordService;
import chap03.DuplicateMemberException;
import chap03.MemberNotFoundException;
import chap03.MemberRegisterService;
import chap03.RegisterRequest;
import chap03.WrongIdPassWordException;
import chap03.assembler.Assembler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {
    private static Assembler assembler = new Assembler();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("input command");
            String command = reader.readLine();
            if(command.equalsIgnoreCase("exit")){
                System.out.println("exit program");
                break;
            }
            if(command.startsWith("new")){
                processNewCommand(command.split(" "));
                continue;
            } else if(command.startsWith("change")){
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] arg) {
        if(arg.length != 5){
            printHelp();
            return;
        }
        MemberRegisterService regSvc = assembler.getMemberRegisterService();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("confirm unequal to password");
            return;
        }
        try{
            regSvc.regist(req);
            System.out.println("regist success");
        } catch (DuplicateMemberException exception){
            System.out.println("already existing email");
        }
    }

    private static void processChangeCommand(String[] arg){
        if(arg.length != 4){
            printHelp();
            return;
        }
        ChangePasswordService changePasswordService = assembler.getChangePasswordService();
        try{
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("change password");
        } catch (MemberNotFoundException exception){
            System.out.println("not existing email");
        } catch (WrongIdPassWordException exception){
            System.out.println("wrong password for this email");
        }
    }

    private static void printHelp(){
        System.out.println();
        System.out.println("wrong command. check command document");
        System.out.println("command document:");
        System.out.println("new email name password confirmpassword");
        System.out.println("change email oldPassword newPassword");
    }

}
