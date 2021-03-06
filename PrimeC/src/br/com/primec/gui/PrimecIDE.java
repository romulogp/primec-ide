package br.com.primec.gui;

import br.com.primec.core.exception.LexicalError;
import br.com.primec.core.Lexico;
import br.com.primec.core.table.Scope;
import br.com.primec.core.exception.SemanticError;
import br.com.primec.core.Semantico;
import br.com.primec.core.Sintatico;
import br.com.primec.core.code.container.AssemblyCodeContainer;
import br.com.primec.core.code.generator.AssemblyCodeGenerator;
import br.com.primec.core.table.SymbolTable;
import br.com.primec.core.exception.SyntaticError;
import br.com.primec.util.FileSaveUtil;
import br.com.primec.util.SystemUtils;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PrimecIDE extends javax.swing.JFrame {

    private Lexico lexico;
    private Sintatico sintatico;
    private Semantico semantico;
    public static Stack<String> scopeStack;    // pilha de escopo
    public static SymbolTable symbolTable;
    public SymbolTableView symbolTableView;
    public boolean containError = true;
    private static int scopeSerialId;
    private boolean modified = false;
    public static AssemblyCodeGenerator asmCodeGen;
    public static AssemblyCodeContainer asmCodeCon;
    
    public PrimecIDE() {
        initComponents();
        initIDEPeculiarities();
    }

    private void initIDEPeculiarities() {
        setLocationRelativeTo(null);
        setFocusTraversalKeysEnabled(false);

        lexico = new Lexico();
        sintatico = new Sintatico();
        semantico = new Semantico();
        initComponentes();
        jTextAreaCode.setTabSize(2);
        jTextAreaCode.requestFocus();
    }

    private void initComponentes() {
        semantico.fullReset();
        asmCodeGen = new AssemblyCodeGenerator();
        asmCodeCon = new AssemblyCodeContainer();
        scopeStack = new Stack();
        scopeStack.push(Scope.GLOBAL.getDescription());
        symbolTable = new SymbolTable();
        scopeSerialId = 0;
    }

    public static int getNextScopeSerial() {
        return scopeSerialId++;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTools = new javax.swing.JPanel();
        jButtonExecute = new javax.swing.JButton();
        jButtonOpen = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonViewSymbolTable = new javax.swing.JButton();
        jButtonViewSymbolTable1 = new javax.swing.JButton();
        jPanelContent = new javax.swing.JPanel();
        jTabbedPaneConsole = new javax.swing.JTabbedPane();
        jScrollPaneConsole = new javax.swing.JScrollPane();
        jTextAreaConsole = new javax.swing.JTextArea();
        jTabbedPaneCode = new javax.swing.JTabbedPane();
        jScrollPaneCode = new javax.swing.JScrollPane();
        jTextAreaCode = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PrimeC IDE");

        jPanelTools.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonExecute.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jButtonExecute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/primec/resources/icons/blue_play-32.png"))); // NOI18N
        jButtonExecute.setToolTipText("Executar");
        jButtonExecute.setFocusable(false);
        jButtonExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExecuteActionPerformed(evt);
            }
        });

        jButtonOpen.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jButtonOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/primec/resources/icons/open-32.png"))); // NOI18N
        jButtonOpen.setToolTipText("Abrir arquivo");
        jButtonOpen.setFocusable(false);
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });

        jButtonNew.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jButtonNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/primec/resources/icons/new-document-32.png"))); // NOI18N
        jButtonNew.setToolTipText("Novo arquivo");
        jButtonNew.setFocusable(false);
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonSave.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/primec/resources/icons/save-32.png"))); // NOI18N
        jButtonSave.setToolTipText("Salvar");
        jButtonSave.setFocusable(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonViewSymbolTable.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jButtonViewSymbolTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/primec/resources/icons/symbol_table-32.png"))); // NOI18N
        jButtonViewSymbolTable.setToolTipText("Tabela de Símbolos");
        jButtonViewSymbolTable.setFocusable(false);
        jButtonViewSymbolTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewSymbolTableActionPerformed(evt);
            }
        });

        jButtonViewSymbolTable1.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jButtonViewSymbolTable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/primec/resources/icons/asm-32.png"))); // NOI18N
        jButtonViewSymbolTable1.setToolTipText("Tabela de Símbolos");
        jButtonViewSymbolTable1.setFocusable(false);
        jButtonViewSymbolTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewSymbolTable1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelToolsLayout = new javax.swing.GroupLayout(jPanelTools);
        jPanelTools.setLayout(jPanelToolsLayout);
        jPanelToolsLayout.setHorizontalGroup(
            jPanelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelToolsLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExecute, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonViewSymbolTable, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonViewSymbolTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelToolsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonExecute, jButtonNew, jButtonOpen, jButtonSave, jButtonViewSymbolTable, jButtonViewSymbolTable1});

        jPanelToolsLayout.setVerticalGroup(
            jPanelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolsLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanelToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonViewSymbolTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonViewSymbolTable, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButtonExecute, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButtonOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        jPanelToolsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonExecute, jButtonNew, jButtonOpen, jButtonSave, jButtonViewSymbolTable, jButtonViewSymbolTable1});

        jButtonViewSymbolTable1.getAccessibleContext().setAccessibleDescription("Gerar Código Assembly");

        jTabbedPaneConsole.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N

        jTextAreaConsole.setColumns(20);
        jTextAreaConsole.setRows(5);
        jTextAreaConsole.setTabSize(2);
        jScrollPaneConsole.setViewportView(jTextAreaConsole);

        jTabbedPaneConsole.addTab("Console", jScrollPaneConsole);

        jTabbedPaneCode.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N

        jTextAreaCode.setColumns(20);
        jTextAreaCode.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextAreaCode.setRows(5);
        jTextAreaCode.setTabSize(2);
        jTextAreaCode.setText("int teste(int valor) {\n\tret valor;\n}\n\nvoid main() {\n\tint a;\n\toutput(teste(a));\n}");
        jTextAreaCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaCodeKeyTyped(evt);
            }
        });
        jScrollPaneCode.setViewportView(jTextAreaCode);

        jTabbedPaneCode.addTab("new1.pmc", jScrollPaneCode);

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(jTabbedPaneConsole))
                .addGap(5, 5, 5))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addComponent(jTabbedPaneCode, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPaneConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExecuteActionPerformed
        initComponentes();
        jTextAreaConsole.setText("");
        lexico.setInput(jTextAreaCode.getText());
        try {
            sintatico.parse(lexico, semantico);
            jTextAreaConsole.setText(jTextAreaConsole.getText() + symbolTable.checkDeclaredNotUsed());
            jTextAreaConsole.setText(jTextAreaConsole.getText() + symbolTable.checkUsedNotInitialized());
            jTextAreaConsole.setText(jTextAreaConsole.getText() + "\n\n" + "CONSTRUÍDO COM SUCESSO...");
            containError = false;
        } catch (LexicalError e) {
            jTextAreaConsole.setText("Erro léximo: " + e.getMessage());
            containError = true;
        } catch (SyntaticError e) {
            jTextAreaConsole.setText("Erro sintático: " + e.getMessage());
            containError = true;
        } catch (SemanticError e) {
            jTextAreaConsole.setText("Erro semântico: " + e.getMessage());
            containError = true;
        }
    }//GEN-LAST:event_jButtonExecuteActionPerformed

    private void jTextAreaCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaCodeKeyTyped
        modified = true;
    }//GEN-LAST:event_jTextAreaCodeKeyTyped

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOpenActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        jTextAreaCode.setText(""
                + "void main() {\n"
                + "\n"
                + "}");
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if (modified) {
//            new File(jTabbedPaneCode.getTitleAt(jTabbedPaneCode.getSelectedIndex()))
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (fileChooser.showOpenDialog(null) != JFileChooser.CANCEL_OPTION){
                System.out.println(fileChooser.getSelectedFile().getPath());
            }
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonViewSymbolTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewSymbolTableActionPerformed
        if (!containError) {
            if (symbolTableView == null) {
                symbolTableView = new SymbolTableView(this, false);
            } else {
                symbolTableView.updateTableContent(symbolTable.getSymbolTable());
            }
            symbolTableView.setVisible(true);
        }
    }//GEN-LAST:event_jButtonViewSymbolTableActionPerformed

    private void jButtonViewSymbolTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewSymbolTable1ActionPerformed
        jButtonExecuteActionPerformed(evt);
        if (!containError) {
            String content = asmCodeCon.build().replace("\n", "\r\n");
            System.out.println(content);
            // Salvar arquivo
            FileSaveUtil fileSaveUtil = new FileSaveUtil("primec.asm");
            fileSaveUtil.save(content);
            // Abrir arquivo
            SystemUtils.openNotepad(fileSaveUtil.getFileFullPath());
        }
    }//GEN-LAST:event_jButtonViewSymbolTable1ActionPerformed

    public static void loadWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class Not Found");
        } catch (IllegalAccessException iae) {
            System.out.println("Illegal Acess Exception");
        } catch (InstantiationException ie) {
            System.out.println("Instantiation Exception");
        } catch (UnsupportedLookAndFeelException ulaf) {
            System.out.println("Unsupported Look and Feel");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PrimecIDE().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExecute;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonViewSymbolTable;
    private javax.swing.JButton jButtonViewSymbolTable1;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelTools;
    private javax.swing.JScrollPane jScrollPaneCode;
    private javax.swing.JScrollPane jScrollPaneConsole;
    private javax.swing.JTabbedPane jTabbedPaneCode;
    private javax.swing.JTabbedPane jTabbedPaneConsole;
    private javax.swing.JTextArea jTextAreaCode;
    private javax.swing.JTextArea jTextAreaConsole;
    // End of variables declaration//GEN-END:variables

}
