/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioautomoviles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class frm_IngresarVersion extends javax.swing.JFrame {

    Marcas ObjMarca=new Marcas();
    Modelos ObjModelo=new Modelos();
    DefaultComboBoxModel ListaMarcas=new DefaultComboBoxModel();
    DefaultComboBoxModel ListaId_Marcas=new DefaultComboBoxModel();
    DefaultComboBoxModel ListaVersionesPorModelo=new DefaultComboBoxModel();
    DefaultComboBoxModel ListaId_Modelos=new DefaultComboBoxModel();
    DefaultListModel<String> ListaVersiones=new DefaultListModel<>();
    DefaultTableModel modelo=new DefaultTableModel();    
    ResultSet rstTabla = null;
    C_ConsultarBodega unidad=new C_ConsultarBodega();
    public frm_IngresarVersion() {
        initComponents();
        this.setLocationRelativeTo(null);
        PrepararCMBMarcas();
        Imprimir();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void MostrarIdMarcas(){
        int posicion=cmb_Marca.getSelectedIndex();
        Id_Marca.setText(String.valueOf(ListaId_Marcas.getElementAt(posicion)));
    }
    private void PrepararCMBMarcas(){   
    ResultSet rstMarca = null;
    ListaMarcas.removeAllElements();
    ListaId_Marcas.removeAllElements();
        try{
            rstMarca = ObjMarca.llenarTabla();
            while (rstMarca.next()) {
                ListaMarcas.addElement(rstMarca.getString(2));                
                ListaId_Marcas.addElement(rstMarca.getString(1)); 
                cmb_Marca.setModel(ListaMarcas);
                MostrarIdMarcas();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        } 
    }
    private void PrepararCMBModelos(){   
    ResultSet rstModelo = null;
    ListaVersionesPorModelo.removeAllElements();
    ListaId_Modelos.removeAllElements();
        try{
            rstModelo = ObjModelo.llenarTabla(cmb_Marca.getSelectedIndex()+1);
            while (rstModelo.next()) {
                ListaVersionesPorModelo.addElement(rstModelo.getString(2));                
                ListaId_Marcas.addElement(rstModelo.getString(1)); 
                cmb_Modelo.setModel(ListaVersionesPorModelo);
                MostrarIdMarcas();
                MostrarSiguienteNdeVersiónParaModelo();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        } 
    }
    
    private void MostrarSiguienteNdeVersiónParaModelo(){  
        ResultSet rstIdModelo= null;
        rstIdModelo =ObjModelo.mayorRegistroDondeMarcaEs(cmb_Marca.getSelectedIndex()+1);
        int Idmodel=0;
        try {
            while(rstIdModelo.next())             
                if(rstIdModelo.getString(1)!=null)
                    Idmodel = Integer.parseInt(rstIdModelo.getString(1));
            if(Idmodel<9)
                lbl_Id_Modelo.setText("00"+(Idmodel+1));
            else if(Idmodel>=9&&Idmodel<99)
                lbl_Id_Modelo.setText("0"+(Idmodel+1));
            else
                lbl_Id_Modelo.setText(String.valueOf((Idmodel+1)));
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
            lbl_Id_Modelo.setText("00001");
        }
        Imprimir();
    }
    private boolean BuscarCoincidenciadeModeloEntrante(String NewModelo){
        boolean found=false;
        for(int fila=0;fila<ListaVersionesPorModelo.getSize();fila++)
        if(ListaVersionesPorModelo.getElementAt(fila).toString().toUpperCase().equals(NewModelo.toUpperCase())){
            found=true;
        }
            
        return found;
    }   
        
    private void PrepararModeloUnidad() {
       while(modelo.getRowCount()>0)modelo.removeRow(0);
       String TitulosdeColumna[]=new String[]{"Marca","Modelo","Version","Color"};
       modelo.setColumnIdentifiers(TitulosdeColumna);
        try{
            rstTabla = unidad.llenarTablaMarcaModeloVersion();
            while (rstTabla.next()) 
                modelo.addRow(new Object[]{rstTabla.getString(2),rstTabla.getString(4),rstTabla.getString(6)});
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
                modelo.addRow(new Object[]{"Error","Error"});
        } 
    } 
    private void Imprimir(){
        PrepararModeloUnidad();
        jTable1.setModel(modelo);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmb_Marca = new javax.swing.JComboBox<>();
        Id_Marca = new javax.swing.JLabel();
        btn_AñadirMarca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_Id_Modelo = new javax.swing.JLabel();
        btn_RegistrarModelo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmb_Modelo = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel1.setText("Seleccione la marca:");

        cmb_Marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Marca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_MarcaItemStateChanged(evt);
            }
        });

        Id_Marca.setText("8888");

        btn_AñadirMarca.setText("Añadir Marca");
        btn_AñadirMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AñadirMarcaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese el nuevo modelo:");

        lbl_Id_Modelo.setText("00000");

        btn_RegistrarModelo.setText("Añadir Modelo");
        btn_RegistrarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarModeloActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        cmb_Modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1.setText("jTextField1");

        jLabel3.setText("jLabel3");

        jLabel4.setText("0000");

        jTextField2.setText("jTextField2");

        jLabel5.setText("jLabel5");

        jButton1.setText("Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_Marca, javax.swing.GroupLayout.Alignment.LEADING, 0, 225, Short.MAX_VALUE)
                                    .addComponent(cmb_Modelo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Id_Marca)
                                            .addComponent(lbl_Id_Modelo))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btn_RegistrarModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_AñadirMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Id_Marca)
                    .addComponent(btn_AñadirMarca))
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_RegistrarModelo)
                    .addComponent(lbl_Id_Modelo)
                    .addComponent(cmb_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_MarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_MarcaItemStateChanged
        MostrarIdMarcas();
        MostrarSiguienteNdeVersiónParaModelo();
    }//GEN-LAST:event_cmb_MarcaItemStateChanged

    private void btn_AñadirMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AñadirMarcaActionPerformed
        frm_IngresarMarca frmMarca= new frm_IngresarMarca();
        frmMarca.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_AñadirMarcaActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        PrepararCMBMarcas();
    }//GEN-LAST:event_formFocusGained

    private void btn_RegistrarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarModeloActionPerformed
        if(jTextField1.getText().length()!=0){
        ObjModelo.insertar(Integer.parseInt(lbl_Id_Modelo.getText()), Integer.parseInt(Id_Marca.getText()), jTextField1.getText());
        MostrarSiguienteNdeVersiónParaModelo();           
        }
        else
            JOptionPane.showMessageDialog(null, "Debe ingresar un criterio");
    }//GEN-LAST:event_btn_RegistrarModeloActionPerformed

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
            java.util.logging.Logger.getLogger(frm_IngresarVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_IngresarVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_IngresarVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_IngresarVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_IngresarVersion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id_Marca;
    private javax.swing.JButton btn_AñadirMarca;
    private javax.swing.JButton btn_RegistrarModelo;
    private javax.swing.JComboBox<String> cmb_Marca;
    private javax.swing.JComboBox<String> cmb_Modelo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_Id_Modelo;
    // End of variables declaration//GEN-END:variables
}
