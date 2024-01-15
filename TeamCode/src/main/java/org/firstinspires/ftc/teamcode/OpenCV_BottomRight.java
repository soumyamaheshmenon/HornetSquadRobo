package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

@Disabled
@TeleOp(name = "HornetSquad: OpenCV Detection Bottom Right", group = "Hornet Vision")
public class OpenCV_BottomRight extends LinearOpMode {
    private RobotHardware robot = new RobotHardware(this);
    private FirstVisionProcessor visionProcessor;
    private VisionPortal visionPortal;

    static final double FORWARD_SPEED = 0.2;
    static final double TURNSPEED = 0.2;
    @Override
    public void runOpMode() {
        robot.init();

        visionProcessor = new FirstVisionProcessor();
        visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "webcam1"), visionProcessor);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            FirstVisionProcessor.Selected selectedDirection = visionProcessor.getSelection();

            telemetry.addData("Identified", selectedDirection);
            telemetry.update();

            if (selectedDirection == FirstVisionProcessor.Selected.LEFT)
                TravelLeft();
            else if (selectedDirection == FirstVisionProcessor.Selected.RIGHT)
                TravelRight();
            else
                //go straight
                TravelStraight();
            telemetry.update();
            break;
        }
    }

    private void TravelLeft()
    {
        telemetry.addData("Go left", "");
        //From Samarth -commenting as its not tested
        //near the bar
        //move forward while turning to left

        /*
        robot.driveRobot(-FORWARD_SPEED, -TURNSPEED);
        sleep(3500);
        robot.driveRobot(0,0);
        robot.driveRobot(FORWARD_SPEED, 0);
        sleep(2000);
        robot.moveArmFullSpeed(RobotHardware.ARM_DOWN_POWER);
        sleep(2700);
        robot.stopArm();

        robot.driveRobot(FORWARD_SPEED, 0);
        sleep(4400);
        robot.driveRobot(0,TURNSPEED);
        sleep(5200);
        robot.driveRobot(FORWARD_SPEED,0);
        sleep(8000);
        robot.moveElbowToPosition(0.3);
        sleep(1000);
        robot.moveGrabberToPosition(RobotHardware.GRABBER_MIN);
        sleep(500);
        robot.moveElbowToPosition(-0.3);
        sleep(1000);
        robot.driveRobot(FORWARD_SPEED,0);
        sleep(1000);

         */
    }
    private void TravelRight()
    {
        telemetry.addData("Go Right", "");
        //robot.driveRobot(FORWARD_SPEED, -TURNSPEED);


    }
    private void TravelStraight()
    {
        //AT top right
        telemetry.addData("Go straight", "");
        robot.goStrafe(-1);
        sleep(200);
        robot.driveRobot(FORWARD_SPEED, 0);
        sleep(5800);
        robot.driveRobot(0,0);

        robot.driveRobot(-FORWARD_SPEED, 0);
        sleep(4400);
        robot.driveRobot(0,-TURNSPEED);
        sleep(5200);
        robot.driveRobot(-FORWARD_SPEED,0);
        sleep(7200);
        robot.moveGrabberToPosition(RobotHardware.GRABBER_MIN);
        sleep(500);
        robot.moveElbowToPosition(-0.3);
        sleep(1000);
        robot.driveRobot(-FORWARD_SPEED,0);
        sleep(1000);



    }
}
