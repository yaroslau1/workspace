package com.work.listener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
 
public class NewJDialog1 extends javax.swing.JDialog {
 
    private jssc.SerialPort serialPort;
 
    private class PortListener implements Runnable {
 
        @Override
        public void run() {
            while (serialPort.isOpened()) {
                try {
                    String ret = serialPort.readString();
                    if (ret != null) {
                        jTextArea1.append(ret);
                    }
                } catch (SerialPortException ex) {
                    Logger.getLogger(NewJDialog1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
            }
        }
 
    }
 
    public NewJDialog1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
 
        String[] strs = null;
        if (System.getProperty("os.name").startsWith("Win")) {
            strs = SerialPortList.getPortNames();
        } else {
            // Тут надо написать что-то под nix...
        }
        jComboBox1.setModel(new DefaultComboBoxModel<>(strs));
    }
 
    private void send() {
        try {
            serialPort.writeBytes(jTextField1.getText().getBytes());
            if (jCheckBox1.isSelected()) {
                serialPort.writeByte((byte) 13);
            }
            if (jCheckBox2.isSelected()) {
                serialPort.writeByte((byte) 10);
            }
            if (jCheckBox3.isSelected()) {
                jTextArea1.append(jTextField1.getText() + "\n");
            }
        } catch (SerialPortException ex) {
            Logger.getLogger(NewJDialog1.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField1.setText("");
        jTextField1.requestFocus();
    }
 
    @SuppressWarnings("unchecked")
    private void initComponents() {
 
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
 
        jLabel1.setText("Port name:");
 
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
 
        jButton1.setText("Send");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
 
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
 
        jToggleButton1.setText("Open");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
 
        jCheckBox1.setText("CR");
 
        jCheckBox2.setText("LF");
 
        jCheckBox3.setText("Echo");
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );
 
        pack();
    }
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        send();
    }                                        
 
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if (jToggleButton1.isSelected()) {
            serialPort = new SerialPort(jComboBox1.getSelectedItem().toString());
 
            try {
                serialPort.openPort();
                serialPort.setParams(jssc.SerialPort.BAUDRATE_9600,
                        jssc.SerialPort.DATABITS_8,
                        jssc.SerialPort.STOPBITS_1,
                        jssc.SerialPort.PARITY_NONE);
            } catch (SerialPortException ex) {
                JOptionPane.showMessageDialog(this, "Не удалось открыть порт!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                jToggleButton1.setSelected(false);
                return;
            }
 
            new Thread(new PortListener()).start();
 
            jComboBox1.setEnabled(false);
            jTextField1.requestFocus();
            jButton1.setEnabled(true);
        } else {
            try {
                serialPort.closePort();
            } catch (SerialPortException ex) {
            }
            jButton1.setEnabled(false);
            jTextField1.setText("");
            jComboBox1.setEnabled(true);
            jComboBox1.requestFocus();
        }
    }                                              
 
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {                                       
        if (evt.getKeyCode() == 10 && jButton1.isEnabled()) {
            send();
        }
    }                                      
 
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
}