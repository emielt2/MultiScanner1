package com.ETMS1;

import DAO_PACKAGE.SQLiteJDBC_DAO;
import DAO_PACKAGE.SQLiteJDBC_Insert_RESULT_VALUES;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.codehaus.groovy.tools.GroovyStarter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class GUI extends Application {
    static public Lock GUIlockobject = new ReentrantLock();
    /*GUI(){
        System.out.println("hi");
    }*/
    Stage primStage;
    static TextArea outText2 = new TextArea();
    static TextArea outText3 = new TextArea();
    //static IntegerProperty latestDatabaseChange=0;
    boolean booleanProperty=false;
    static int latestDatabaseChange=0;
    static final LongProperty longPropertyDatabaseChanged = new SimpleLongProperty();
    //static boolean activeBrowsers[]=new boolean[6];
    static boolean activeBrowsers[]={true,true,false,false,false,false};
    /*public static void setOutText2(String text){
        outText2.setText(outText2.getText()+text);
    }*/
    public static TextArea getOutText2(){
        return outText2;
    }
    public static TextArea getOutText3(){
        return outText3;
    }

    //tabletry extras:
    private TableView<ResultObjForTable> table = new TableView<ResultObjForTable>();
    static final ObservableList<ResultObjForTable> data =
            FXCollections.observableArrayList(
                    //new ResultObjForTable("Jacob", "Smith", "jacob.smith@example.com"),
                    //new ResultObjForTable("Isabella", "Johnson", "isabella.johnson@example.com"),
                    /*new ResultObjForTable("Run001", "TestcaseGoogle1", "CHROME", "OK", "39000", "OK"),
                    new ResultObjForTable("Run002", "TestcaseGoogle2", "CHROME", "FAIL", "30000", "Exception text asdf asdf asdf asdf asdf asdf asdf asdfasdfasdfasfdasdf"),
                    new ResultObjForTable("Run003", "TestcaseGebbish1", "CHROME", "FAIL", "15000", "Assert text failed asdf asdf asdf asdf asdf asdf asdf asdf "),
                    */new ResultObjForTable("Run004", "TestcaseGebbish2", "CHROME", "OK", "39000", "OK")


            );

    @Override
    public void start(Stage primaryStage) {
/**------------- Initialize Stages, Create Grids/Scenes-------------**/
        primStage = primaryStage;

        primStage.setTitle("Title here");
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_LEFT);
        grid1.setHgap(5);
        grid1.setVgap(5);
        grid1.setPadding(new Insets(1, 25, 25, 25));
        //grid1.setMinHeight(1790);
        final Scene sceneOne = new Scene(grid1, 1000, 950);

/**------------- Buttons -------------**/
        final Button button01 = new Button("Buton01");
        Button button02 = new Button("Buton02");
        Button button03 = new Button("Buton03--------");

/**------------- Checkboxes -------------**/
        final CheckBox checkbox1 = new CheckBox("Check1");
        checkbox1.setSelected(true);
        final CheckBox checkbox2 = new CheckBox("Check2");
        checkbox2.setSelected(true);

/**------------- Graphical separators -------------**/
        Separator sepHor1 = new Separator();
        Separator sepHor2 = new Separator();
        Separator sepVer1 = new Separator();
        //sepVer1.setMinHeight(800);
        sepVer1.setOrientation(Orientation.VERTICAL);//Vertical separator
        sepHor1.setMinWidth(360);
/**------------- Texts inputfields/outputfields -------------**/
        final Text outText1 = new Text("Welcome User47281");

        /*final TextArea outText2 = new TextArea("TextArea outText2 / Last results:");//moved to static*/
        outText2 = new TextArea("TextArea outText2 / Last results:");
        outText2.setMinHeight(100);
        outText2.setMaxHeight(100);
        outText3 = new TextArea("TextArea outText3 / Reports:");
        outText3.setMinHeight(300);
        outText3.setMaxHeight(300);
        final TextField inputField1 = new TextField("inputField1");
        final TextField outputField1ActionText = new TextField("outputField1");
        inputField1.setMinHeight(22);
        outputField1ActionText.setMinHeight(22);
        inputField1.setAlignment(Pos.TOP_LEFT);
        outText1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

/**TABLE TRY VANAF HIER----**/
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn testRunCol = new TableColumn("TestRun");
        testRunCol.setMinWidth(130);
        testRunCol.setCellValueFactory(
                new PropertyValueFactory<ResultObjForTable, String>("TestRun"));


        TableColumn testCaseNameCol = new TableColumn("TestCaseName");
        testCaseNameCol.setMinWidth(130);
        testCaseNameCol.setCellValueFactory(
                new PropertyValueFactory<ResultObjForTable, String>("TestCaseName"));


        TableColumn browserChoiceCol = new TableColumn("Browser");
        browserChoiceCol.setMinWidth(55);
        browserChoiceCol.setCellValueFactory(
                new PropertyValueFactory<ResultObjForTable, String>("BrowserChoice"));//Need UPPERcase to use getters/setters


        TableColumn resultCol = new TableColumn("result");
        resultCol.setMinWidth(40);
        resultCol.setCellValueFactory(new PropertyValueFactory<ResultObjForTable, String>("result"));


        TableColumn timeTakenmilisCol = new TableColumn("Time taken");
        timeTakenmilisCol.setMinWidth(70);
        timeTakenmilisCol.setCellValueFactory(
                new PropertyValueFactory<ResultObjForTable, String>("timeTakenmilis"));


        TableColumn openTextCol = new TableColumn("openTextCol");
        openTextCol.setMinWidth(250);
        openTextCol.setPrefWidth(300);
        openTextCol.setCellValueFactory(
                new PropertyValueFactory<ResultObjForTable, String>("OpenText"));
        table.setItems(data);
        table.getColumns().addAll(testRunCol, testCaseNameCol, browserChoiceCol, timeTakenmilisCol, resultCol, openTextCol);
        final VBox vboxTABLE = new VBox();
        vboxTABLE.setMinWidth(900);
        vboxTABLE.setMaxWidth(900);
        vboxTABLE.setMinHeight(300);
        vboxTABLE.setMaxHeight(300);
        vboxTABLE.setSpacing(5);
        vboxTABLE.setPadding(new Insets(10, 0, 0, 10));
        vboxTABLE.getChildren().addAll(label, table);


/**------------- Contentboxes to fill with buttons/texts/etc, add to Grids later -------------**/
        final HBox hBox1 = new HBox(40);
        HBox hBox2 = new HBox(40);
        final VBox vBox1 = new VBox(10);
        final VBox vBox2 = new VBox(40);

/**------------- Fill Boxes -------------**/
        final VBox vBox00A = new VBox(10);
        final VBox vBox00B = new VBox(10);
        final VBox vBox00C = new VBox(10);
        hBox1.getChildren().addAll(vBox00A,vBox00B,vBox00C);
        vBox00A.getChildren().addAll(inputField1, button01);
        //hBox1.getChildren().addAll(inputField1, button01);
        vBox00B.getChildren().addAll(outputField1ActionText,checkbox1,checkbox2, button02, button03);
        //vBox1.getChildren().addAll(outputField1ActionText,checkbox1,checkbox2, button02, button03);
        //vBox2.getChildren().addAll(outText1,outText2);
        vBox00C.getChildren().addAll(outText1,outText2);
        //vBox2.setMinHeight(10);
        vBox1.setStyle("-fx-border-color: black;");
/**------------- Buttonactions and on-field action like Enter -------------**/

        inputField1.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent e) {
                                        try {
                                            System.out.println("Enter pressed in field");
                                            button01.fire();
                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                }
        );

        button01.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    System.out.println("Button01 clicked");
                    String urlApp1 = "http://localhost:63342/QuickHtml/htmlApp1.html";
                    String urlApp2 = "http://localhost:63342/QuickHtml/htmlApp2.html";
                    //GroovyBrowserDaoETMS1 tempy = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html");
                    ShellRunner gbd0 = new ShellRunner("http://localhost:63342/QuickHtml/htmlApp1.html",0);
                    ShellRunner gbd1 = new ShellRunner("http://localhost:63342/QuickHtml/htmlApp2.html",1);
                    ShellRunner gbd2 = new ShellRunner("http://localhost:63342/QuickHtml/htmlApp1.html",2);
                    ShellRunner gbd3 = new ShellRunner("http://localhost:63342/QuickHtml/htmlApp2.html",3);
                    ShellRunner gbd4 = new ShellRunner("http://localhost:63342/QuickHtml/htmlApp1.html",3);
                    ShellRunner gbd5 = new ShellRunner("http://localhost:63342/QuickHtml/htmlApp2.html",3);

                    //gbd.RunGroovyShellMulti("F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\main\\java\\com\\ETMS1\\TestCase01.groovy");
                    Thread thread0 = new Thread(gbd0);
                    Thread thread1 = new Thread(gbd1);
                    Thread thread2 = new Thread(gbd2);
                    Thread thread3 = new Thread(gbd3);
                    Thread thread4 = new Thread(gbd4);
                    Thread thread5 = new Thread(gbd5);

                    int sleeptime = 3000;
                    thread0.start();
                    Thread.sleep(sleeptime);
                    thread1.start();
                    Thread.sleep(sleeptime);
                    /*thread2.start();
                    Thread.sleep(sleeptime);
                    thread3.start();
                    Thread.sleep(sleeptime);
                    thread4.start();
                    Thread.sleep(sleeptime);
                    thread5.start();*/
                    //while(checkbox1.isSelected()){
                        //outText2.setText("sleeptime = " + sleeptime++);
                       // Thread.sleep(100);


                    //}
                } catch (Exception ex1) {
                    ex1.printStackTrace();
                }

            }
        });


        button02.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {


                    //GroovyBrowserDaoETMS1 gbd1 = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html");//werkte
                    //GroovyBrowserDaoETMS1 gbd1 = new GroovyBrowserDaoETMS1(fileName);
                    //GroovyBrowserDaoETMS1 gbd2 = new GroovyBrowserDaoETMS1("http://localhost:63342/QuickHtml/htmlApp.html");//werkte
                    //gbd.RunProcessBuilder("F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\src\\test\\java\\com\\ETMS1\\TestCase01.groovy");
                    //synchronized (fileName){
                    //GroovyTestRunner gtr[]=new GroovyTestRunner[15];
                    int totalspots=6;
                    int totaltestruns = 20;
                    SQLiteJDBC_DAO.resetTableBrowserSharing(totalspots);
                    ExecutorService exserv = Executors.newFixedThreadPool(totalspots);

                    for(int i=0;i<totaltestruns;i++){
                        //for(int y=0;y<totalspots;y++);

                        String fileNameString = "output_" + new FunctionsDaoETS2().getDateString()+ ".log";
                        //GroovyBrowserDaoETMS1.ShellToFixRestoreChrome(new File("Y:/Browser_profile"+i+"/Default"));//TODO
                        //gtr[i]=new GroovyTestRunner(fileNameString);
                        //Thread gtrThread1 = new Thread(gtr[i]);
                        //gtrThread1.start();
                        Thread tryThread = new Thread(new GroovyTestRunner(fileNameString));
                        exserv.submit(tryThread);
                        //new Thread(new GroovyTestRunner(fileNameString)).start();
                        //tryThread.start();
                        //tryThread.join();
                        //tryTh
                        Thread.sleep(1000);
                    }

/*
                    GroovyTestRunner gtr1 = new GroovyTestRunner(fileNameString);
                    Thread gtrThread1 = new Thread(gtr1);
                    gtrThread1.start();
*/


                    //}

                    //Thread t2 = new Thread(gbd2);

                    //Thread.sleep(3000);
                    //t2.start();
                    //boolean t1alive
                    //t1.join();
                    //Thread.sleep(3000);
                    /*synchronized (t1){
                        t1.wait();
                    }*/

                    /*for(boolean b=true;b;){//SLEEP AND MAKE FILE
                        Thread.sleep(3000);
                        System.out.println("t1 Alive = " + (b=t1.isAlive()));
                        System.out.println("t1 State = " + t1.getState());
                        System.out.println("t1 Id = " + t1.getId());
                        System.out.println("t1 Name = " + t1.getName());
                        //System.out.println("t2 Alive = " + t2.isAlive());
                    }*/



/*
                    FileReader in = new FileReader(new File(fileName));
                    LineNumberReader lineIn = new LineNumberReader(in);
                    boolean end = false;
                    while (!end)
                    {
                        try
                        {
                            //if (lineIn.readLine() == null)
                            String line = lineIn.readLine();
                            //{
                              //  end = true;
                            //}
                        if(line.contains("JUnit 4 Runner, Tests: ")){
                            System.out.println("Current line : " + line);
                            end=true;
                            line= line.substring(line.indexOf(":")+2);
                            line = line.trim();
                            System.out.println(line.substring(0,line.indexOf(",")));
                            int testsAmount = Integer.parseInt(line.substring(0,line.indexOf(",")));
                            line = line.substring(line.indexOf(":")+2);
                            int failuresAmount = Integer.parseInt(line.substring(0,line.indexOf(",")));
                            System.out.println("testsAmout="+testsAmount);
                            System.out.println("failuresAmount="+failuresAmount);
                            if(failuresAmount==0)System.out.println("RESULT is SUCCESS (" + testsAmount + "/"+testsAmount+" passed!)");
                            else System.out.println("RESULT is FAILED ("+failuresAmount+"/"+testsAmount+" failed, " + (testsAmount-failuresAmount) + "/" + testsAmount + " passed.)");
                        }

                        }
                        catch (IOException ex2)
                        {
                            ex2.printStackTrace();
                        }
                    }
                    */
                } catch (Exception ex1) {
                    ex1.printStackTrace();
                }

            }
        });
        button03.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    //GUI xgui = new GUI();
                    //xgui.getNewBrowserNumber();
                   // outputField1ActionText.setText(""+xgui.getNewBrowserNumber());//TODO DIT WAS YEAR AGO
                    //data.removeAll();
                    outText3.setText(outText3.getText()+"\nSome text here: "+data.add(new ResultObjForTable("Testrun005", "TestcaseGoogle5", "CHROME", "FAIL", "50000", "Exception text")));
                    Thread.sleep(200);
                    outText3.setText(outText3.getText()+"\nSome text here: "+data.add(new ResultObjForTable("Testrun006", "TestcaseGoogle5", "CHROME", "FAIL", "50000", "Exception text")));
                    //data.remove(new ResultObjForTable("Testrun005", "TestcaseGoogle5", "CHROME", "FAIL", "50000", "Exception text"));
                    //data.removeAll(new ResultObjForTable("Testrun005", "TestcaseGoogle5", "CHROME", "FAIL", "50000", "Exception text"));
                    System.out.println("index"+data.indexOf(new ResultObjForTable("Testrun005", "TestcaseGoogle5", "CHROME", "FAIL", "50000", "Exception text")));
                    data.clear();
                    System.out.println(data.size());
                } catch (Exception ex1) {
                    ex1.printStackTrace();
                }

            }
        });
//--------------------------------------------------------------
        final ChangeListener changeListenerDatabase = new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //System.out.println("oldValue:"+ oldValue + ", newValue = " + newValue);
                System.out.println("longProperty has changed, new value = " + longPropertyDatabaseChanged);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
                Date resultdate = new Date(longPropertyDatabaseChanged.getValue());
                System.out.println(sdf.format(resultdate));
                //outText2.setText(outText2.getText()+"\nLatest change = " + longPropertyDatabaseChanged);
                outText2.setText(outText2.getText()+"\nLatest change = " + sdf.format(resultdate));
                outText3.setText("OUTTEXT3");

            }
        };
        longPropertyDatabaseChanged.addListener(changeListenerDatabase);
//--------------------------------------------------------------
        /*ChangeListener cl = new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println("\n\n\nChangeListener TEXT\n\n\n");
            }
        };*/


/**
 ------------- Fill grids with boxes -------------
 *
 */
        int grid1leftcounter = 0;
        //grid1.add(sepVer1, 1, 0,1,30);

        grid1.add(hBox1, 0, grid1leftcounter++);//url conn
        //grid1.add(button01, 0, grid1leftcounter++);
        //grid1.add(outputField1ActionText, 0, grid1leftcounter++);
        //grid1.add(vBox2, 1, grid1leftcounter);
        //grid1.add(sepHor2, 0, grid1leftcounter++);
        grid1.add(vBox1, 0, grid1leftcounter++);//groovyshell

        grid1.add(sepHor1, 0, grid1leftcounter++);
        grid1.add(hBox2, 0, grid1leftcounter++);
        grid1.add(vboxTABLE, 0, grid1leftcounter++);
        grid1.add(outText3, 0, grid1leftcounter++);


        //grid1.add(outText1, 0, grid1leftcounter);
        //grid1.add(vBox2, 1, 0,1,10);//TODO BIG CHANGED
        //grid1.add(outText2, 0, grid1leftcounter++);
/**------------- Fill Scene  -------------**/
        primStage.setScene(sceneOne);
        primStage.getScene().fillProperty();
        //primStage.alwaysOnTopProperty();//JAVA8needed
        primStage.show();

        /**
         * Start Auto browser
         */
        try {
           // button02.fire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * End Auto browser
         */
    }

    /**
     * ------------- Main LAUNCH GUI -------------
     **/
    public static void main(String[] args) {
        launch(args);
        System.out.println("STARTED");
    }
    synchronized public int getNewBrowserNumber(){
        for(int i=0;i<activeBrowsers.length-1;i++){     //-1 !!!!!!!!!!!!!
            //System.out.println("numberOfActiveBrowsers=" + activeBrowsers);
            if( activeBrowsers[i]==false){
                System.out.println("FALSE FOR "+i);
                activeBrowsers[i]=true;
                if( activeBrowsers[i]==false)System.out.println("STILL FALSE FOR "+i);
                else System.out.println("CHANGED TO TRUE FOR BROWSER "+i);
                System.out.println("TRYING DB HERE:");
                SQLiteJDBC_Insert_RESULT_VALUES.getLastID();
                return i;

            }
            System.out.println("numberOfActiveBrowsers ABC=" + activeBrowsers[i]);
        }
    return -1;
        //return activeBrowsers;
    }



    public static class ResultObjForTable {

        private final SimpleStringProperty testRunssp;//firstName
        private final SimpleStringProperty testCaseNamessp;//TestCaseName
        private final SimpleStringProperty browserChoicessp;//TestCaseName
        private final SimpleStringProperty resultssp;//result
        private final SimpleStringProperty timeTakenmilisssp;//newTotalTime
        private final SimpleStringProperty openTextssp;//newopenText



        /*private*/ ResultObjForTable(String testRun, String testCaseName, String browserChoice, String result, String timeTakenmilis, String openText) {
            this.testRunssp = new SimpleStringProperty(testRun);
            this.testCaseNamessp = new SimpleStringProperty(testCaseName);
            this.browserChoicessp = new SimpleStringProperty(browserChoice);
            this.resultssp = new SimpleStringProperty(result);
            this.timeTakenmilisssp = new SimpleStringProperty(timeTakenmilis);
            this.openTextssp = new SimpleStringProperty(openText);
        }

        public String getTestRun() {
            return testRunssp.get();
        }

        public void setTestRun(String var) {
            testRunssp.set(var);
        }


        public String getTestCaseName() {
            return testCaseNamessp.get();
        }

        public void setTestCaseName(String var) {
            testCaseNamessp.set(var);
        }


        public String getBrowserChoice() {
            return browserChoicessp.get();
        }

        public void setBrowserChoice(String var) {
            browserChoicessp.set(var);
        }

        public String getResult() {
            return resultssp.get();
        }

        public void setResult(String var) {
            resultssp.set(var);
        }

        public String getTimeTakenmilis() {
            return timeTakenmilisssp.get();
        }

        public void setTimeTakenmilis(String var) {
            timeTakenmilisssp.set(var);
        }

        public String getOpenText() {
            return openTextssp.get();
        }

        public void setOpenText(String var) {
            openTextssp.set(var);
        }
    }
}