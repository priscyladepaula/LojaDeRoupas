/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ItemVenda;

/**
 *
 * @author sunse
 */
public class ListaCompras extends javax.swing.JFrame {

    /**
     * Creates new form ListaCompras
     */
    ArrayList<ItemVenda> itensDaVendaSelecionada;
    String nomeCliente;
    String cpfCliente;
    
    public ListaCompras(ArrayList<ItemVenda> itens, String nome, String cpf) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Compras do cliente");
        
        itensDaVendaSelecionada = itens;
        nomeCliente = nome;
        cpfCliente = cpf;
        
         DefaultTableModel tmProdutosDetalhes = new DefaultTableModel();
        
        tmProdutosDetalhes.addColumn("PRODUTO");
        tmProdutosDetalhes.addColumn("QUANTIDADE");
        tmProdutosDetalhes.addColumn("VALOR");
        jTableDetalhes.setModel(tmProdutosDetalhes);
        
        jTableDetalhes.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTableDetalhes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTableDetalhes.getColumnModel().getColumn(2).setPreferredWidth(80);       
        
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                
        jTableDetalhes.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTableDetalhes.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTableDetalhes.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        
        for(ItemVenda item : itensDaVendaSelecionada){
            String[] vetorItens = {String.valueOf(item.getDescricaoProduto()), String.valueOf(item.getQtd()),
                    String.valueOf(item.getValorUnitario())};
            
            tmProdutosDetalhes.addRow(vetorItens);
        }
        jLabelDescricaoNomeCliente.setText(nomeCliente);
        jLabelDescricaoCpfCliente.setText(cpfCliente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableDetalhes = new javax.swing.JTable();
        jLabelDescricaoNomeCliente = new javax.swing.JLabel();
        jLabelDescricaoCpfCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "LISTA DE COMPRAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel7.setText("NOME:");

        jLabel8.setText("CPF:");

        jTableDetalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUTO", "QUANTIDADE", "VALOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableDetalhes);

        jLabelDescricaoNomeCliente.setText("Nome do Cliente");

        jLabelDescricaoCpfCliente.setText("78965412300");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDescricaoCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDescricaoNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelDescricaoNomeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelDescricaoCpfCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDescricaoCpfCliente;
    private javax.swing.JLabel jLabelDescricaoNomeCliente;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableDetalhes;
    // End of variables declaration//GEN-END:variables
}
