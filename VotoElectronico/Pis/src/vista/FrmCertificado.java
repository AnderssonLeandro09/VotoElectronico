/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Wilman
 */
public class FrmCertificado extends javax.swing.JFrame {

    private String cedula;
    private String nombre;
    private String nacionalidad;

    /**
     * Creates new form FrmCertificado
     */
    public FrmCertificado() {
        initComponents();
    }

    String fechaHora = "";

    public void generarCertificado() {

        // Obtener la información del archivo JSON
        JSONObject jsonObject = leerInfo();

        // Crear el documento PDF
        String dest = "C:\\Users\\Usuario Asus\\Documents\\NetBeansProjects\\Pis\\data\\certificado.pdf";

        try (PdfWriter writer = new PdfWriter(dest)) {
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Obtener los datos del JSON
            JSONObject datoObj = (JSONObject) jsonObject.get("dato1");
            long cedulaLocal = (long) datoObj.get("cedula");
            String nombreLocal = (String) datoObj.get("nombre");
            String nacionalidadLocal = (String) datoObj.get("nacionalidad");

            // Crear los párrafos con la información obtenida
            Paragraph para = new Paragraph("Certificado de votación");
            Paragraph para1 = new Paragraph("Cédula: " + cedulaLocal);
            Paragraph para2 = new Paragraph("Nombre: " + nombreLocal);
            Paragraph para3 = new Paragraph("Nacionalidad: " + nacionalidadLocal);

            // Agregar los párrafos al documento PDF
            document.add(para);
            document.add(para1);
            document.add(para2);
            document.add(para3);

            document.close();
            System.out.println("PDF creado");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JSONObject leerInfo() {
        JSONParser jsonParser = new JSONParser();

        JSONObject jsonObject = null;

        String filePath = "C:\\Users\\Usuario Asus\\Documents\\NetBeansProjects\\Pis\\data\\persona.json";

        try (FileReader reader = new FileReader(filePath)) {
            
            jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONObject listaEnlazadaObj = (JSONObject) jsonObject.get("controlador.lista.ListaEnlazada");
            JSONObject cabezaObj = (JSONObject) listaEnlazadaObj.get("cabeza");
            JSONObject datoObj = (JSONObject) cabezaObj.get("dato");

            
            long id = (long) datoObj.get("id");
            long cedulaLocal1 = (long) datoObj.get("cedula");
            String nombreLocal1 = (String) datoObj.get("nombre");
            String nacionalidadLocal1 = (String) datoObj.get("nacionalidad");

            System.out.println("Informacion de la primera persona:");
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombreLocal1);
            System.out.println("Nacionalidad: " + nacionalidadLocal1);
            System.out.println("Cedula: " + cedulaLocal1);

            JSONObject siguienteObj = (JSONObject) cabezaObj.get("siguiente");
            //JSONObject datoObj = (JSONObject) siguienteObj.get("dato");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

//    private boolean verificarCredenciales(String cedulaLocal, String contra) throws JSONException {
//        // Leer el archivo JSON y analizar su contenido
//        String jsonStr = "{\"controlador.ed.listas.ListaEnlazada\":{\"cabecera\":{\"info\":{\"@class\":\"modelo.Cuenta\",\"id\":1,\"Usuario\":1150182051,\"Contra\":\"cristian\",\"estado\":true}},\"size\":1}}";
//        JSONObject jsonObject = new JSONObject(jsonStr);
//        JSONObject listaEnlazada = jsonObject.getJSONObject("controlador.ed.listas.ListaEnlazada");
//        JSONObject cabecera = listaEnlazada.getJSONObject("cabecera");
//        JSONObject info = cabecera.getJSONObject("info");
//
//        // Obtener los datos de la cuenta del archivo JSON
//        String usuarioJson = info.getString("Usuario");
//        String contraJson = info.getString("Contra");
//
//        // Comparar las credenciales ingresadas con los datos del archivo JSON
//        if (usuarioJson.equals(cedulaLocal) && contraJson.equals(contra)) {
//            return true; // Credenciales válidas
//        } else {
//            return false; // Credenciales inválidas
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnOk)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btnOk)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        generarCertificado();
    }//GEN-LAST:event_btnOkActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCertificado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCertificado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCertificado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCertificado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCertificado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
