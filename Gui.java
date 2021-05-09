package project.gui;

import project.models.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import project.database.databaseConnection;

   public class Gui{
       public databaseConnection dbHandler;
       private JFrame start;


       public Gui(databaseConnection dbHandler){
           this.dbHandler = dbHandler;
      start = new JFrame("User Options");
      start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      start.setSize(1000,500);
      start.setLayout (new GridLayout(5,3));
      createStartscreen();

   	}

    public void createStartscreen(){
      JPanel startScreen = new JPanel();

      //these are the query buttons

        JButton createButton = new JButton("Insertion Queries");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createInsertionScreen(start);
            }
        });
        JButton updateButton = new JButton("Update Queries");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createUpdateScreen(start);
            }
        });

        JButton selectionButton = new JButton("Selection Queries");
        selectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSelectionScreen(start);
            }
        });

        JButton projectionButton = new JButton("Projection Queries");
        projectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createProjectionScreen(start);
            }
        });

        JButton joinButton = new JButton("Join Queries");
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createJoinScreen(start);
            }
        });

        JButton aggregationGroupButton = new JButton("Aggregation with Group By Queries");
        aggregationGroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAggregation1Screen(start);
            }
        });

        JButton aggregationHavingButton = new JButton("Aggregation with Having Queries");
        aggregationHavingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAggregation2Screen(start);
            }
        });

        JButton nestedAggregationGroupButton = new JButton("Nested Aggregation with Group By Queries");
        nestedAggregationGroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSelectionScreen(start);
            }
        });

        JButton divisionButton = new JButton("Division Queries");
        divisionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSelectionScreen(start);
            }
        });

        start.getContentPane().add(createButton);
        start.getContentPane().add(updateButton);
        start.getContentPane().add(selectionButton);
        start.getContentPane().add(projectionButton);
        start.getContentPane().add(joinButton);
        start.getContentPane().add(aggregationGroupButton);
        start.getContentPane().add(aggregationHavingButton);
        start.getContentPane().add(nestedAggregationGroupButton);
        start.getContentPane().add(divisionButton);
       start.setVisible(true);
    }
    public void createInsertionScreen(JFrame parent){
           JFrame insert = new JFrame("Insertion Queries");
        insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insert.setSize(1000,500);
        insert.setLayout (new GridLayout(5,3));
        JPanel insertScreen = new JPanel();
       //these are the query buttons

           JButton userButton = new JButton("Insert User");
            userButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   createUserInsertScreen(insert);
               }
           });
            JButton returnButton = new JButton("Return to start");
            returnButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    insert.setVisible(false);
                    start.setVisible(true);
                }
            });
            insertScreen.add(userButton);
            insertScreen.add(returnButton);
           insert.getContentPane().add(insertScreen);
           insert.setVisible(true);
           parent.setVisible(false);
       }




    //this is the new screen for every single query option
    public void createUserInsertScreen(JFrame parent){
      JFrame create = new JFrame("Create a User");
      create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      create.setSize(500,300);
      GridBagConstraints c = new GridBagConstraints();

        JPanel createScreen = new JPanel();
        createScreen.setLayout(new GridBagLayout());
        JLabel sin = new JLabel("SIN");
        JTextField sinField = new JTextField(16);
        JLabel idtype = new JLabel("ID Type");
        JTextField idtypeField = new JTextField(16);;
        JLabel id = new JLabel("ID Number");
        JTextField idField = new JTextField(16);
        JLabel name = new JLabel("Name");
        JTextField nameField = new JTextField(16);
        JLabel address = new JLabel("Address");
        JTextField addressField = new JTextField(16);
        JLabel phone = new JLabel("Phone Number");
        JTextField phoneField = new JTextField(16);
        JLabel email = new JLabel("Email");
        JTextField emailField = new JTextField(16);
        JLabel password = new JLabel("Password");
        JTextField passwordField = new JTextField(16);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        createScreen.add(sin, c);
        c.gridx = 1;
        c.gridy = 0;
        createScreen.add(sinField, c);
        c.gridx = 0;
        c.gridy = 1;
        createScreen.add(idtype, c);
        c.gridx = 1;
        c.gridy = 1;
        createScreen.add(idtypeField, c);
        c.gridx = 0;
        c.gridy = 2;
        createScreen.add(id, c);
        c.gridx = 1;
        c.gridy = 2;
        createScreen.add(idField, c);
        c.gridx = 0;
        c.gridy = 3;
        createScreen.add(name, c);
        c.gridx = 1;
        c.gridy = 3;
        createScreen.add(nameField, c);
        c.gridx = 0;
        c.gridy = 4;
        createScreen.add(address, c);
        c.gridx = 1;
        c.gridy = 4;
        createScreen.add(addressField, c);
        c.gridx = 0;
        c.gridy = 5;
        createScreen.add(phone, c);
        c.gridx = 1;
        c.gridy = 5;
        createScreen.add(phoneField, c);
        c.gridx = 0;
        c.gridy = 6;
        createScreen.add(email, c);
        c.gridx = 1;
        c.gridy = 6;
        createScreen.add(emailField, c);
        c.gridx = 0;
        c.gridy = 7;
        createScreen.add(password, c);
        c.gridx = 1;
        c.gridy = 7;
        createScreen.add(passwordField, c);

      JButton submit = new JButton("Submit");
      submit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             int custID = dbHandler.getNextUserID();
            int sins = Integer.parseInt(sinField.getText());
            String idtypes = idtypeField.getText();
            String idnums = idtypeField.getText();
            String names = nameField.getText();
            String addresss = addressField.getText();
            String phones = phoneField.getText();
            String email = emailField.getText();
            String passs = passwordField.getText();
            UserAccount newUser = new UserAccount(custID, sins, idtypes, idnums, names, addresss, phones, email, passs);
            dbHandler.doInsertUserAccount(newUser);

          create.setVisible(false);
          parent.setVisible(true);
         }
       });
      c.gridx = 1;
      c.gridy = 9;
      createScreen.add(submit, c);

      create.getContentPane().add(createScreen);
      create.setVisible(true);
      parent.setVisible(false);
    }

       public void createUpdateScreen(JFrame parent){
           JFrame update = new JFrame("Updateion Queries");
           update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           update.setSize(1000,500);
           update.setLayout (new GridLayout(5,3));
           JPanel updateScreen = new JPanel();
           //these are the query buttons

           JButton userButton = new JButton("Update User Address");
           userButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   createUserAddressScreen(update);
               }
           });
           JButton returnButton = new JButton("Return to start");
           returnButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   update.setVisible(false);
                   start.setVisible(true);
               }
           });
           updateScreen.add(userButton);
           updateScreen.add(returnButton);
           update.getContentPane().add(updateScreen);
           update.setVisible(true);
           parent.setVisible(false);
       }

       public void createUserAddressScreen(JFrame parent){
           JFrame upAdd = new JFrame("Update a User Address");
           upAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           upAdd.setSize(500,300);
           GridBagConstraints c = new GridBagConstraints();

           JPanel uppAddScreen = new JPanel();
           uppAddScreen.setLayout(new GridBagLayout());
           JLabel custID = new JLabel("Customer ID");
           JTextField custIDField = new JTextField(16);
           JLabel newAdd = new JLabel("New Address");
           JTextField newAddField = new JTextField(16);;
           c.weightx = 0.5;
           c.gridx = 0;
           c.gridy = 0;
           uppAddScreen.add(custID, c);
           c.gridx = 1;
           c.gridy = 0;
           uppAddScreen.add(custIDField, c);
           c.gridx = 0;
           c.gridy = 1;
           uppAddScreen.add(newAdd, c);
           c.gridx = 1;
           c.gridy = 1;
           uppAddScreen.add(newAddField, c);

           JButton submit = new JButton("Submit");
           submit.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   int custIDs = Integer.parseInt(custIDField.getText());
                   String newAdds = newAddField.getText();
                    dbHandler.doUserAddUpdate(custIDs, newAdds);
                   upAdd.setVisible(false);
                   parent.setVisible(true);
               }
           });
           c.gridx = 1;
           c.gridy = 2;
           uppAddScreen.add(submit, c);

           upAdd.getContentPane().add(uppAddScreen);
           upAdd.setVisible(true);
           parent.setVisible(false);
       }

       public void createSelectionScreen(JFrame parent){
           JFrame selection = new JFrame("Selection Queries");
           selection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           selection.setSize(1000,500);
           selection.setLayout (new GridLayout(5,3));
           JPanel selectionScreen = new JPanel();
           //these are the query buttons

           JButton userButton = new JButton("Selection Users With Min Balance");
           userButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   createUserMinSelectScreen(selection);
               }
           });
           JButton returnButton = new JButton("Return to start");
           returnButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   selection.setVisible(false);
                   start.setVisible(true);
               }
           });
           selectionScreen.add(userButton);
           selectionScreen.add(returnButton);
           selection.getContentPane().add(selectionScreen);
           selection.setVisible(true);
           parent.setVisible(false);
       }
       public void createUserMinSelectScreen(JFrame parent){
           JFrame userMinSelect = new JFrame("Select a User");
           userMinSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           userMinSelect.setSize(500,300);
           GridBagConstraints c = new GridBagConstraints();

           JPanel userMinSelectScreen = new JPanel();
           userMinSelectScreen.setLayout(new GridBagLayout());
           JLabel minBal = new JLabel("Minimum Balance");
           JTextField minBalField = new JTextField(16);
           c.weightx = 0.5;
           c.gridx = 0;
           c.gridy = 0;
           userMinSelectScreen.add(minBal, c);
           c.gridx = 1;
           c.gridy = 0;
           userMinSelectScreen.add(minBalField, c);

           JButton submit = new JButton("Submit");
           submit.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   TradingAccount[] results;
                   int minBals = Integer.parseInt(minBalField.getText());
                   results = dbHandler.doMinBalSelection(minBals);
                   for (TradingAccount a:results){
                       System.out.println(a.toString());
                   }
                   userMinSelect.setVisible(false);
                   parent.setVisible(true);
               }
           });
           c.gridx = 1;
           c.gridy = 1;
           userMinSelectScreen.add(submit, c);

           userMinSelect.getContentPane().add(userMinSelectScreen);
           userMinSelect.setVisible(true);
           parent.setVisible(false);
       }

       public void createProjectionScreen(JFrame parent){
           JFrame projection = new JFrame("Projection Queries");
           projection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           projection.setSize(1000,500);
           projection.setLayout (new GridLayout(5,3));
           JPanel projectionScreen = new JPanel();
           //these are the query buttons

           JButton userButton = new JButton("Select with Projection Table");
           userButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   createProjectSelectScreen(projection);
               }
           });

           JButton returnButton = new JButton("Return to start");
           returnButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   projection.setVisible(false);
                   start.setVisible(true);
               }
           });
           projectionScreen.add(userButton);
           projectionScreen.add(returnButton);
           projection.getContentPane().add(projectionScreen);
           projection.setVisible(true);
           parent.setVisible(false);
       }

       public void createProjectSelectScreen(JFrame parent){
           JFrame selectProject = new JFrame("Select a User");
           selectProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           selectProject.setSize(500,300);
           GridBagConstraints c = new GridBagConstraints();

           JPanel selectProjectScreen = new JPanel();
           selectProjectScreen.setLayout(new GridBagLayout());
           JLabel table = new JLabel("Select Table");
           JTextField tableField = new JTextField(16);
           JLabel column = new JLabel("Select Column");
           JTextField columnField = new JTextField(16);
           c.weightx = 0.5;
           c.gridx = 0;
           c.gridy = 0;
           selectProjectScreen.add(table, c);
           c.gridx = 1;
           c.gridy = 0;
           selectProjectScreen.add(tableField, c);
           c.weightx = 0.5;
           c.gridx = 0;
           c.gridy = 1;
           selectProjectScreen.add(column, c);
           c.gridx = 1;
           c.gridy = 1;
           selectProjectScreen.add(columnField, c);

           JButton submit = new JButton("Submit");
           submit.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   String tables = tableField.getText();
                   String columns = columnField.getText();
                   String[] results;
                   results = dbHandler.doProjectSelection(tables, columns);
                   for (String s:results) {
                       System.out.println(s);
                   }
                   selectProject.setVisible(false);
                   parent.setVisible(true);
               }
           });
           c.gridx = 1;
           c.gridy = 2;
           selectProjectScreen.add(submit, c);

           selectProject.getContentPane().add(selectProjectScreen);
           selectProject.setVisible(true);
           parent.setVisible(false);
       }

       public void createJoinScreen(JFrame parent){
           JFrame join = new JFrame("Join Queries");
           join.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           join.setSize(1000,500);
           join.setLayout (new GridLayout(5,3));
           JPanel joinScreen = new JPanel();
           //these are the query buttons

           JButton userButton = new JButton("Join Users With Min Balance");
           userButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   createJoinUserTradeScreen(join);
               }
           });
           JButton returnButton = new JButton("Return to start");
           returnButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   join.setVisible(false);
                   start.setVisible(true);
               }
           });
           joinScreen.add(userButton);
           joinScreen.add(returnButton);
           join.getContentPane().add(joinScreen);
           join.setVisible(true);
           parent.setVisible(false);
       }

       public void createJoinUserTradeScreen(JFrame parent){
           JFrame userMinSelect = new JFrame("Select a User");
           userMinSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           userMinSelect.setSize(500,300);
           GridBagConstraints c = new GridBagConstraints();

           JPanel userMinSelectScreen = new JPanel();
           userMinSelectScreen.setLayout(new GridBagLayout());
           JLabel minBal = new JLabel("Minimum Balance");
           JTextField minBalField = new JTextField(16);
           c.weightx = 0.5;
           c.gridx = 0;
           c.gridy = 0;
           userMinSelectScreen.add(minBal, c);
           c.gridx = 1;
           c.gridy = 0;
           userMinSelectScreen.add(minBalField, c);

           JButton submit = new JButton("Submit");
           submit.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   int minBals = Integer.parseInt(minBalField.getText());
                   String[][] results;
                   results = dbHandler.doJoinUserTrade(minBals);
                   for (int i = 0; i < results[0].length; i++) {
                       System.out.print(i + 1 + " ");
                       for (int j = 0; j < results.length; j++) {
                           System.out.print(results[j][i] + " ");
                       }
                        System.out.println();

                   }
                   userMinSelect.setVisible(false);
                   parent.setVisible(true);
               }
           });
           c.gridx = 1;
           c.gridy = 1;
           userMinSelectScreen.add(submit, c);

           userMinSelect.getContentPane().add(userMinSelectScreen);
           userMinSelect.setVisible(true);
           parent.setVisible(false);
       }
       public void createAggregation1Screen(JFrame parent){
           JFrame aggregation1 = new JFrame("Aggregation Queries");
           aggregation1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           aggregation1.setSize(1000,500);
           aggregation1.setLayout (new GridLayout(5,3));
           JPanel aggregation1Screen = new JPanel();
           //these are the query buttons

           JButton userButton = new JButton("Aggregation Users Derivatives");
           userButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   createAggregationDerivativesScreen(aggregation1);
               }
           });
           JButton returnButton = new JButton("Return to start");
           returnButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   aggregation1.setVisible(false);
                   start.setVisible(true);
               }
           });
           aggregation1Screen.add(userButton);
           aggregation1Screen.add(returnButton);
           aggregation1.getContentPane().add(aggregation1Screen);
           aggregation1.setVisible(true);
           parent.setVisible(false);
       }

       public void createAggregationDerivativesScreen(JFrame parent){
           JFrame userMinSelect = new JFrame("Select a User");
           userMinSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           userMinSelect.setSize(500,300);
           GridBagConstraints c = new GridBagConstraints();

           JPanel userMinSelectScreen = new JPanel();
           userMinSelectScreen.setLayout(new GridBagLayout());

           JButton submit = new JButton("Start");
           submit.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   String[][] results;
                   results = dbHandler.doAggregationDerivatives();
                   for (int i = 0; i < results[0].length; i++) {
                       System.out.print(i + 1 + " ");
                       for (int j = 0; j < results.length; j++) {
                           System.out.print(results[j][i] + " ");
                       }
                       System.out.println();

                   }
                   userMinSelect.setVisible(false);
                   parent.setVisible(true);
               }
           });
           c.gridx = 1;
           c.gridy = 1;
           userMinSelectScreen.add(submit, c);

           userMinSelect.getContentPane().add(userMinSelectScreen);
           userMinSelect.setVisible(true);
           parent.setVisible(false);
       }

       public void createAggregation2Screen(JFrame parent){
           JFrame aggregation2 = new JFrame("Aggregation2 Queries");
           aggregation2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           aggregation2.setSize(1000,500);
           aggregation2.setLayout (new GridLayout(5,3));
           JPanel aggregation2Screen = new JPanel();
           //these are the query buttons

           JButton userButton = new JButton("Aggregation2 Users Derivatives");
           userButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   createAggregationDerivativesHavingScreen(aggregation2);
               }
           });
           JButton returnButton = new JButton("Return to start");
           returnButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   aggregation2.setVisible(false);
                   start.setVisible(true);
               }
           });
           aggregation2Screen.add(userButton);
           aggregation2Screen.add(returnButton);
           aggregation2.getContentPane().add(aggregation2Screen);
           aggregation2.setVisible(true);
           parent.setVisible(false);
       }

       public void createAggregationDerivativesHavingScreen(JFrame parent){
           JFrame userMinSelect = new JFrame("Select a User");
           userMinSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           userMinSelect.setSize(500,300);
           GridBagConstraints c = new GridBagConstraints();

           JPanel userMinSelectScreen = new JPanel();
           userMinSelectScreen.setLayout(new GridBagLayout());

           JButton submit = new JButton("Start");
           submit.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   String[][] results;
                   results = dbHandler.doAggregationDerivativesHaving();
                   for (int i = 0; i < results[0].length; i++) {
                       System.out.print(i + 1 + " ");
                       for (int j = 0; j < results.length; j++) {
                           System.out.print(results[j][i] + " ");
                       }
                       System.out.println();

                   }
                   userMinSelect.setVisible(false);
                   parent.setVisible(true);
               }
           });
           c.gridx = 1;
           c.gridy = 1;
           userMinSelectScreen.add(submit, c);

           userMinSelect.getContentPane().add(userMinSelectScreen);
           userMinSelect.setVisible(true);
           parent.setVisible(false);
       }

/*
    public void editUserScreen(){
      JFrame edit = new JFrame("Edit a User");
      edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      edit.setSize(500,300);
      GridBagConstraints c = new GridBagConstraints();

      JPanel editScreen = new JPanel();
      editScreen.setLayout(new GridBagLayout());
      JLabel userName = new JLabel("Username");
      JTextField userNameField = new JTextField(16);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = 0.5;
      c.gridx = 0;
      c.gridy = 0;
      editScreen.add(userName, c);
      c.gridx = 1;
      c.gridy = 0;
      editScreen.add(userNameField, c);

      JButton submit = new JButton("Submit");
      submit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
          String user = userNameField.getText();

             //dbHandler.doSQLQuery();

             edit.setVisible(false);
          start.setVisible(true);
         }
       });
      c.gridx = 1;
      c.gridy = 5;
      editScreen.add(submit, c);

      edit.getContentPane().add(editScreen);
      edit.setVisible(true);
      start.setVisible(false);
    }*/
  }
