package inventarioautomoviles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class frm_IngresarMarca extends javax.swing.JFrame {

    C_Marcas ObjMarca=new C_Marcas();
    DefaultListModel<String> ListaMarcas=new DefaultListModel<>();
    public frm_IngresarMarca() {
        initComponents();
        Prepararmodelodelista();
        this.setLocationRelativeTo(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void Prepararmodelodelista(){   
    ResultSet rstMarca = null;
    ListaMarcas.removeAllElements();
        try{
            rstMarca = ObjMarca.llenarTabla();
            while (rstMarca.next())
                ListaMarcas.addElement(rstMarca.getString(2));
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
                ListaMarcas.addElement("Error");
        } 
    }
    
    private boolean BuscarCoincidenciadeMarcaEntrante(String NewMarca){
        boolean found=false;
        for(int fila=0;fila<ListaMarcas.getSize();fila++)
        if(ListaMarcas.getElementAt(fila).toUpperCase().equals(NewMarca.toUpperCase()))
            found=true;
        return found;
    }      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_IngreseMarca = new javax.swing.JLabel();
        txt_MarcaEntrante = new javax.swing.JTextField();
        btn_Añadir = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lbl_IngreseMarca.setText("Ingrese la nueva marca:");

        txt_MarcaEntrante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MarcaEntranteKeyTyped(evt);
            }
        });

        btn_Añadir.setText("Añadir");
        btn_Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AñadirActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Ingresar Modelo");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_MarcaEntrante, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_IngreseMarca)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_IngreseMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_MarcaEntrante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Añadir)
                    .addComponent(btn_Cancelar)
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AñadirActionPerformed
        if(txt_MarcaEntrante.getText().length()!=0)
            if(!BuscarCoincidenciadeMarcaEntrante(txt_MarcaEntrante.getText())){
                JOptionPane.showMessageDialog(null, "Se ha registrado con éxito");
                ObjMarca.insertar(txt_MarcaEntrante.getText());
                Prepararmodelodelista();
            }else
                JOptionPane.showMessageDialog(null, "La marca "+txt_MarcaEntrante.getText()+" ya ha sido registrada antes");
        else
            JOptionPane.showMessageDialog(null, "Debe ingresar un criterio");
    }//GEN-LAST:event_btn_AñadirActionPerformed
        String vengodesde;
    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        frm_IngresarModelo FRMModelo= new frm_IngresarModelo();
            FRMModelo.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void txt_MarcaEntranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MarcaEntranteKeyTyped
        if(txt_MarcaEntrante.getText().length()==50)
            evt.consume();
    }//GEN-LAST:event_txt_MarcaEntranteKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(vengodesde=="modelo"){
            frm_IngresarModelo FRMModelo= new frm_IngresarModelo();
            FRMModelo.setVisible(true);
            this.dispose(); 
        } else if(vengodesde=="version"){
            frm_IngresarVersion vers=new frm_IngresarVersion();  
            this.dispose();
            vers.setVisible(true);
        } else {
            frm_Bodega bode=new frm_Bodega();
            bode.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_IngresarMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_IngresarMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_IngresarMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_IngresarMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_IngresarMarca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Añadir;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbl_IngreseMarca;
    private javax.swing.JTextField txt_MarcaEntrante;
    // End of variables declaration//GEN-END:variables
}
