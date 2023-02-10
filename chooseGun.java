import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class chooseGun extends JFrame
{
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField gunTextField;
    private JTextField primOneTextField;
    private JTextField primTwoTextField;
    private JTextField primSightField;
    private JTextField gunTextField2;
    private JTextField secOneField;
    private JTextField secTwoField;
    private JTextField gunTextField3;
    private JTextField titaOneField;
    private JTextField titaTwoField;
    private JButton calcButton;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 600;
    private Random random;
    private final List<String> primaryList;
    private final List<String> secondaryList;
    private final List<String> titanList;
    private final List<String> sniperScopes;
    private final List<String> sniperAttachments;
    private final List<String> dmrAttachments;
    private final List<String> shotGunSmgSights;
    private final List<String> arAttachments;
    private final List<String> arSights;
    private final List<String> lmgSights;
    private final List<String> eliteAttachments;
    private final List<String> grenAttachments;
    private final List<String> secAttachments;
    private final List<String> titaAttachments;
    private final List<String> cRifleAttachments;
    
    public chooseGun() {
        this.random = new Random();
        this.primaryList = Arrays.asList("G2A5", "Hemlok", "R-201", "R-101", "Flatline", "Alternator", "CAR", "R-97", "Volt", "L-Star", "Spitfire", "X-55 Devotion", "Double Take", "Kraber", "Longbow DMR", "EM-4 Cold War", "EPG-1", "R-6p Softball", "Sidewinder SMR", "EVA-8 Shotgun", "Mastiff", "Wingman Elite", "Mozambique");
        this.secondaryList = Arrays.asList("B3 Wingman", "Hammond P2016", "RE-45 Auto");
        this.titanList = Arrays.asList("Archer", "Charge Rifle", "LG-97 Thunderbolt", "MGL Mag Launcher");
        this.sniperScopes = Arrays.asList("Factory Issue", "Threat Scope", "Variable Zoom");
        this.sniperAttachments = Arrays.asList("Extra Ammo", "Speed Loader", "Gun Ready", "Quick Swap", "Tactikill", "Ricochet");
        this.dmrAttachments = Arrays.asList("Extra Ammo", "Speed Loader", "Gun Ready", "Quick Swap", "Tactikill");
        this.shotGunSmgSights = Arrays.asList("Factory Issue", "Threat Scope", "HCOG Ranger", "Holosight");
        this.arAttachments = Arrays.asList("Extra Ammo", "Speed Loader", "Gun Runner", "Quick Swap", "Tactikill", "Gun Ready");
        this.arSights = Arrays.asList("Factory Issue", "HCOG", "HCOG Ranger", "Threat Scope");
        this.lmgSights = Arrays.asList("Factory Issue", "AOG", "HCOG Ranger", "Threat Scope");
        this.eliteAttachments = Arrays.asList("Extra Ammo", "Ricochet", "Gun Runner", "Speedloader", "Tactikill", "Gun Ready");
        this.grenAttachments = Arrays.asList("Extra Ammo", "Gun Runner", "Speedloader", "Gun Ready", "Tactikill", "Quick Swap");
        this.secAttachments = Arrays.asList("Extra Ammo", "Suppressor", "Speedloader", "Gunrunner", "Gun Ready", "Tactikill");
        this.titaAttachments = Arrays.asList("Extra Ammo", "Speedloader", "Gun Ready", "Quick Swap");
        this.cRifleAttachments = Arrays.asList("Extra Ammo", "Charge Hack", "Gun Ready", "Quick Swap");
        this.setTitle("Titanfall Class Generator");
        this.setSize(400, 600);
        this.setDefaultCloseOperation(3);
        this.buildPanel();
        this.add(this.panel);
        this.setVisible(true);
    }
    
    private String attachmentReRoll(final String one, String two, final List<String> attachTypeList) {
        while (one == two) {
            two = attachTypeList.get(this.random.nextInt(attachTypeList.size()));
        }
        return two;
    }
    
    private void buildPanel() {
        this.messageLabel = new JLabel("Primary Weapon");
        this.gunTextField = new JTextField(30);
        this.primOneTextField = new JTextField(30);
        this.primTwoTextField = new JTextField(30);
        this.primSightField = new JTextField(30);
        (this.calcButton = new JButton("Create Class")).addActionListener(new CalcButtonListener());
        (this.panel = new JPanel()).add(this.messageLabel);
        this.panel.add(this.gunTextField);
        this.gunTextField.setEditable(false);
        this.panel.add(this.primOneTextField);
        this.panel.add(this.primTwoTextField);
        this.panel.add(this.primSightField);
        this.primSightField.setEditable(false);
        this.primOneTextField.setEditable(false);
        this.primTwoTextField.setEditable(false);
        this.messageLabel = new JLabel("Seconday Weapon");
        this.gunTextField2 = new JTextField(30);
        this.secOneField = new JTextField(30);
        this.secTwoField = new JTextField(30);
        this.panel.add(this.messageLabel);
        this.panel.add(this.gunTextField2);
        this.panel.add(this.secOneField);
        this.panel.add(this.secTwoField);
        this.gunTextField2.setEditable(false);
        this.secOneField.setEditable(false);
        this.secTwoField.setEditable(false);
        this.messageLabel = new JLabel("Anti Titan Weapon");
        this.gunTextField3 = new JTextField(30);
        this.titaOneField = new JTextField(30);
        this.titaTwoField = new JTextField(30);
        this.panel.add(this.messageLabel);
        this.panel.add(this.gunTextField3);
        this.panel.add(this.titaOneField);
        this.panel.add(this.titaTwoField);
        this.gunTextField3.setEditable(false);
        this.titaOneField.setEditable(false);
        this.titaTwoField.setEditable(false);
        this.panel.add(this.calcButton);
    }
    
    public static void main(final String[] args) {
        new chooseGun();
    }
    
    private class CalcButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(final ActionEvent arg0) {
            final String prim = chooseGun.this.primaryList.get(chooseGun.this.random.nextInt(chooseGun.this.primaryList.size()));
            String primOne = "";
            String primTwo = "";
            String primSight = "";
            final String sec = chooseGun.this.secondaryList.get(chooseGun.this.random.nextInt(chooseGun.this.secondaryList.size()));
            String secOne = "";
            String secTwo = "";
            final String tita = chooseGun.this.titanList.get(chooseGun.this.random.nextInt(chooseGun.this.titanList.size()));
            String titaOne = "";
            String titaTwo = "";
            if(tita == "Charge Rifle")
            {
            	titaOne = chooseGun.this.cRifleAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.cRifleAttachments.size()));
                titaTwo = chooseGun.this.cRifleAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.cRifleAttachments.size()));
                if (titaOne == titaTwo) {
                    titaTwo = chooseGun.this.attachmentReRoll(titaOne, titaTwo, chooseGun.this.cRifleAttachments);
                }
            }
            else {
            	titaOne = chooseGun.this.titaAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.titaAttachments.size()));
                titaTwo = chooseGun.this.titaAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.titaAttachments.size()));
                if (titaOne == titaTwo) {
                    titaTwo = chooseGun.this.attachmentReRoll(titaOne, titaTwo, chooseGun.this.titaAttachments);
                }
            }
            secOne = chooseGun.this.secAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.secAttachments.size()));
            secTwo = chooseGun.this.secAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.secAttachments.size()));
            if (secOne == secTwo) {
                secTwo = chooseGun.this.attachmentReRoll(secOne, secTwo, chooseGun.this.secAttachments);
            }
            
            if(prim =="Hemlok" || prim == "Alternator" || prim  == "R-201" || prim == "R-101" || prim == "G2A5" || prim == "Flatline") {
            	primOne = chooseGun.this.arAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.arAttachments.size()));
            	primSight = chooseGun.this.arSights.get(chooseGun.this.random.nextInt(chooseGun.this.arSights.size()));
                if (primSight != "Threat Scope") {
                	primTwo = chooseGun.this.arAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.arAttachments.size()));
                    if (primOne == primTwo) {
                        primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.arAttachments);
                    }
                }
            }
            else if (prim == "Mastiff" || prim == "EVA-8 Shotgun" || prim == "CAR" || prim == "R-97" || prim == "Volt") {
            	primOne = chooseGun.this.arAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.arAttachments.size()));
            	primSight = chooseGun.this.shotGunSmgSights.get(chooseGun.this.random.nextInt(chooseGun.this.shotGunSmgSights.size()));
                if (primSight != "Threat Scope") {
                	primTwo = chooseGun.this.arAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.arAttachments.size()));
                    if (primOne == primTwo) {
                        primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.arAttachments);
                    }
                }
            }
            else if (prim == "L-Star" || prim == "Spitfire" || prim == "X-55 Devotion") {
            	primOne = chooseGun.this.arAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.arAttachments.size()));
            	primSight = chooseGun.this.lmgSights.get(chooseGun.this.random.nextInt(chooseGun.this.lmgSights.size()));
                if (primSight != "Threat Scope") {
                	primTwo = chooseGun.this.arAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.arAttachments.size()));
                    if (primOne == primTwo) {
                        primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.arAttachments);
                    }
                }
            }
            else if(prim == "EM-4 Cold War" || prim == "R-6p Softball" || prim == "EPG-1" || prim == "Sidewinder SMR") {
            	primOne = chooseGun.this.grenAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.grenAttachments.size()));
                primTwo = chooseGun.this.grenAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.grenAttachments.size()));
                if (primOne == primTwo) {
                    primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.grenAttachments);
                }
            }
            else if(prim == "Kraber" || prim == "Double Take") {
            	primOne = chooseGun.this.dmrAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.dmrAttachments.size()));
                primSight = chooseGun.this.sniperScopes.get(chooseGun.this.random.nextInt(chooseGun.this.sniperScopes.size()));
                if (primSight != "Threat Scope") {
                	primTwo = chooseGun.this.sniperAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.sniperAttachments.size()));
                    if (primOne == primTwo) {
                        primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.sniperAttachments);
                    }
                }
            }
            else if(prim == "Longbow DMR") {
            	primOne = chooseGun.this.dmrAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.dmrAttachments.size()));
                primSight = chooseGun.this.sniperScopes.get(chooseGun.this.random.nextInt(chooseGun.this.sniperScopes.size()));
                if (primSight != "Threat Scope") {
                	primTwo = chooseGun.this.dmrAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.dmrAttachments.size()));
                    if (primOne == primTwo) {
                        primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.dmrAttachments);
                    }
                }
            }
            else if(prim == "Wingman Elite") {
            	primOne = chooseGun.this.eliteAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.eliteAttachments.size()));
                primTwo = chooseGun.this.eliteAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.eliteAttachments.size()));
                if (primOne == primTwo) {
                    primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.eliteAttachments);
                }
            }
            else if (prim  == "Mozambique") {
            	primOne = chooseGun.this.secAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.secAttachments.size()));
                primTwo = chooseGun.this.secAttachments.get(chooseGun.this.random.nextInt(chooseGun.this.secAttachments.size()));
                if (primOne == primTwo) {
                    primTwo = chooseGun.this.attachmentReRoll(primOne, primTwo, chooseGun.this.secAttachments);
                }
            }
            chooseGun.this.gunTextField.setText(prim);
            chooseGun.this.primOneTextField.setText(primOne);
            chooseGun.this.primTwoTextField.setText(primTwo);
            chooseGun.this.primSightField.setText(primSight);
            chooseGun.this.gunTextField2.setText(sec);
            chooseGun.this.secOneField.setText(secOne);
            chooseGun.this.secTwoField.setText(secTwo);
            chooseGun.this.gunTextField3.setText(tita);
            chooseGun.this.titaOneField.setText(titaOne);
            chooseGun.this.titaTwoField.setText(titaTwo);
        }
    }
}
