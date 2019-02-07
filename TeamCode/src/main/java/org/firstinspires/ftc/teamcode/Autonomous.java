package org.firstinspires.ftc.teamcode;

/**
 * Created by standalone on 14-5-2018.
 */



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous_Yeeeee", group="Auto")

public class Autonomous extends LinearOpMode {

    DcMotor LeftDrive = null;
    DcMotor RightDrive = null;
    Servo Klep = null;
    DcMotor LiftSysteem = null;
    DcMotor LiftSysteem2 = null;
    DcMotor LiftSysteem3 = null;


    @Override
    public void runOpMode() throws InterruptedException {
        LeftDrive = hardwareMap.dcMotor.get("LeftDrive");
        RightDrive = hardwareMap.dcMotor.get("RightDrive");
        Klep = hardwareMap.servo.get("Klep");
        LiftSysteem = hardwareMap.dcMotor.get("LiftSysteem");
        LiftSysteem2 = hardwareMap.dcMotor.get("LiftSysteem2");
        LiftSysteem3 = hardwareMap.dcMotor.get("Liftsysteem3");

        waitForStart();

        DriveForwardTime(1, 900);
        DriveForwardTime(0, 100);
        LiftTime(0.2, 1500);
        LiftTime(-0.2, 1500);
        TurnRightTime(0.35, 2000);
        DriveForwardTime(1, 2200);
        DriveForwardTime(0, 100);
        LiftTime(0.3, 3000);


    }

    public void DriveForward(double power) {
        LeftDrive.setPower(-power);
        RightDrive.setPower(power);

    }

    public void DriveForwardTime(double power, long time) throws InterruptedException {
        DriveForward(power);
        Thread.sleep(time);
    }


    public void TurnRight(double power) {
        LeftDrive.setPower(-power);
        RightDrive.setPower(-power);

    }

    public void TurnRightTime(double power, long time) throws InterruptedException {
        TurnRight(power);
        Thread.sleep(time);
    }

   public void Arm_yeet(double power) {
        LiftSysteem2.setPower(power);
   }

   public void Arm_yeettime(double power, long time) throws InterruptedException {
        Arm_yeet(power);
        Thread.sleep(time);
   }


    public void Lift3(double power) {
        LiftSysteem3.setPower(power);
    }

    public void LiftTime(double power, long time) throws InterruptedException {
        Lift3(power);
        Thread.sleep(time);
    }

}