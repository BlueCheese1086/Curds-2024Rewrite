package frc.robot.Drivetrain.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain.Drivetrain;

public class MecanumTime extends Command {
    /** This makes the process of selecting a direction for the robot to go easier. */
    public enum Directions {
        UP,
        UPRIGHT,
        RIGHT,
        DOWNRIGHT,
        DOWN,
        DOWNLEFT,
        LEFT,
        UPLEFT;
    }

    private Drivetrain drivetrain;
    private double speed;
    private Directions direction;
    private double end;

    /** Creates a new MecanumTime command.  This will move the robot in a certain direction at a set speed for a certain number of seconds.
     * 
     * @param drivetrain The subsystem this command will run on.
     * @param speed The speed the robot will move at.
     * @param direction The direction the robot will move.
     * @param seconds How long the robot will move in seconds.
     */
    public MecanumTime(Drivetrain drivetrain, double speed, Directions direction, double seconds) {
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.direction = direction;
        this.end = System.currentTimeMillis() + (seconds * 1000);

        addRequirements(drivetrain);
    }

    @Override
    /** Called every time the scheduler runs while the command is scheduled. */
    public void execute() {
        switch(direction) {
            case UP:
                drivetrain.drive(speed, speed, speed, speed);
            case UPRIGHT:
                drivetrain.drive(speed, 0, 0, speed);
            case RIGHT:
                drivetrain.drive(speed, -speed, -speed, speed);
            case DOWNRIGHT:
                drivetrain.drive(0, -speed, -speed, 0);
            case DOWN:
                drivetrain.drive(-speed, -speed, -speed, -speed);
            case DOWNLEFT:
                drivetrain.drive(-speed, 0, 0, -speed);
            case LEFT:
                drivetrain.drive(-speed, speed, speed, -speed);
            case UPLEFT:
                drivetrain.drive(0, speed, speed, 0);
        }
    }

    @Override
    /** Called once the command ends or is interrupted. */
    public void end(boolean interrupted) {
        drivetrain.drive(0, 0, 0, 0);
    }

    @Override
    /** Returns true when the command should end. */
    public boolean isFinished() {
        return (System.currentTimeMillis() == end);
    }
}