package Java_Arduino.ArduinoRX_multi;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class ArduinoGUI extends javax.swing.JFrame implements ActionListener {

    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    ArduinoGUI.cpu1 cpu1 = new cpu1();

    private InputStream Input = null;
    String msg;
    int mostrar, segu, mint;
    Calendar c = new GregorianCalendar();

    //Conexion de Java a Arduino
    public ArduinoGUI() {
        //manda indicador a la pantalla LCD
        initComponents();
        setLocationRelativeTo(null);

        //Iniciala un hilo para obtener la hora del sistema actual en tiempo real
        cpu1.start();
        //conexion de Java a Arduino
        try {
            //Se inicia la comunicación con el Puerto Serie
            ino.arduinoTX("COM3", 9600);
        } catch (ArduinoException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonHora = new javax.swing.JButton();
        BotonCaptura = new javax.swing.JButton();
        CapturaTexto = new javax.swing.JTextField();
        BotonTemp = new javax.swing.JButton();
        ver = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java-Arduino");
        setBackground(new java.awt.Color(255, 255, 255));

        BotonHora.setBackground(new java.awt.Color(204, 204, 204));
        BotonHora.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        BotonHora.setText("Obtener la Hora");
        BotonHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHoraActionPerformed(evt);
            }
        });

        BotonCaptura.setBackground(new java.awt.Color(204, 204, 204));
        BotonCaptura.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        BotonCaptura.setText("Enviar Texto");
        BotonCaptura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturaActionPerformed(evt);
            }
        });

        CapturaTexto.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N

        BotonTemp.setBackground(new java.awt.Color(204, 204, 204));
        BotonTemp.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        BotonTemp.setText("Obtener temperatura");
        BotonTemp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BotonTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTempActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonCaptura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonTemp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CapturaTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addComponent(ver))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonHora, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(ver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapturaTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //al clickear en boton hora
    private void BotonHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHoraActionPerformed
        try {
            //manda el mensaje de la hora del sistema btenida anteriormente
            cpu1.sleep(1500);
            ino.sendData("Hora: "+msg);
            System.out.println(msg);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonHoraActionPerformed

    //al clickear en el boton enviar texto
    private void BotonCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCapturaActionPerformed
        try {
            //envia al Arduino el texto que se escribio en el text anteriormente
            ino.sendData(CapturaTexto.getText());
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonCapturaActionPerformed

    //al clickear en el boton de temperatura
    private void BotonTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTempActionPerformed
        try {
            //manda al IDE de Arduino el dato 2 para que realice la actividad que se encuentra en el IDE
            ino.sendData("+");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonTempActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArduinoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCaptura;
    private javax.swing.JButton BotonHora;
    private javax.swing.JButton BotonTemp;
    private javax.swing.JTextField CapturaTexto;
    private javax.swing.JTextField ver;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
//  Se crea una clase  privada para obtener la hora 
    private class cpu1 extends Thread {

        @Override
        public void run() {
            while (true) {
                //Variables Candelar para formar el formato de la hora
                Calendar c = new GregorianCalendar();
                //Obtiene la hora del día
                mostrar = c.get(Calendar.HOUR_OF_DAY);
                //Obtiene los segundos actual
                segu = c.get(Calendar.SECOND);
                //Obtiene el minuto actual
                mint = c.get(Calendar.MINUTE);
                //Se forma la hora según el formato deseado
                msg = mostrar + ":" + mint + ":" + segu;
                //Manda la hora el Jtexfield para mostrar la hora
                ver.setText(msg);
            }
        }
    }
}
