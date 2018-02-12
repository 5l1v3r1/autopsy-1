/*
 * Autopsy Forensic Browser
 *
 * Copyright 2018 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.corecomponentinterfaces.DataSourceProcessor;
import org.sleuthkit.autopsy.coreutils.MessageNotifyUtil;
import java.util.logging.Level;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import org.apache.commons.lang3.StringUtils;
import org.openide.util.NbBundle.Messages;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.coreutils.PathValidator;

final class L01Panel extends javax.swing.JPanel implements DocumentListener {

    private static final long serialVersionUID = 1L;

    private final Set<File> currentFiles = new TreeSet<>(); //keep currents in a set to disallow duplicates per add
    private static final Logger logger = Logger.getLogger(LocalFilesPanel.class.getName());
    private String displayName = "";
    private static final String L01_EXTENSION = ".l01";

    /**
     * Creates new form L01Panel
     */
    private L01Panel() {
        initComponents();
        l01FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        l01FileChooser.setAcceptAllFileFilterUsed(false);
        l01FileChooser.setMultiSelectionEnabled(false);
        l01FileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                } else {
                    return pathname.getName().toLowerCase().endsWith(L01_EXTENSION);
                }
            }

            @Override
            public String getDescription() {
                return "Logical Evidence Files (L01)";
            }
        });
    }

    static synchronized L01Panel createInstance() {
        L01Panel instance = new L01Panel();
        // post-constructor initialization of listener support without leaking references of uninitialized objects
        instance.jTextField1.getDocument().addDocumentListener(instance);
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l01FileChooser = new javax.swing.JFileChooser();
        selectButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        l01FileChooser.setApproveButtonText(org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.l01FileChooser.approveButtonText")); // NOI18N
        l01FileChooser.setApproveButtonToolTipText(org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.l01FileChooser.approveButtonToolTipText")); // NOI18N
        l01FileChooser.setDialogTitle(org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.l01FileChooser.dialogTitle")); // NOI18N
        l01FileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        org.openide.awt.Mnemonics.setLocalizedText(selectButton, org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.selectButton.text")); // NOI18N
        selectButton.setToolTipText(org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.selectButton.toolTipText")); // NOI18N
        selectButton.setActionCommand(org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.selectButton.actionCommand")); // NOI18N
        selectButton.setMaximumSize(new java.awt.Dimension(70, 23));
        selectButton.setMinimumSize(new java.awt.Dimension(70, 23));
        selectButton.setPreferredSize(new java.awt.Dimension(70, 23));
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        jTextField1.setText(org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.jTextField1.text")); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(379, 20));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(errorLabel, org.openide.util.NbBundle.getMessage(L01Panel.class, "L01Panel.errorLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorLabel)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        int returnVal = l01FileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = l01FileChooser.getSelectedFile();
            StringBuilder allPaths = new StringBuilder();
            currentFiles.add(file);
            allPaths.append(file.getAbsolutePath());
            jTextField1.setText(allPaths.toString());
            jTextField1.setToolTipText(allPaths.toString());
        }
        fireChange();
    }//GEN-LAST:event_selectButtonActionPerformed

    void reset() {
        jTextField1.setText("");
        jTextField1.setToolTipText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JFileChooser l01FileChooser;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables

    @Messages({
        "L01Panel.validatePanel.nonL01Error.text=Only files with the .l01 file extension are supported here."
    })
    boolean validatePanel() {
        errorLabel.setVisible(false);
        // display warning if there is one (but don't disable "next" button)
        String path = jTextField1.getText();
        if (StringUtils.isBlank(path)) {
            return false;
        }
        // display warning if there is one (but don't disable "next" button)
        if (false == PathValidator.isValid(path, Case.getCurrentCase().getCaseType())) {
            errorLabel.setVisible(true);
            errorLabel.setText(Bundle.DataSourceOnCDriveError_text());
            return false;
        }
        //check the extension incase the path was manually entered
        if (!path.toLowerCase().endsWith(L01_EXTENSION)) {
            errorLabel.setVisible(true);
            errorLabel.setText(Bundle.L01Panel_validatePanel_nonL01Error_text());
            return false;
        }

        return new File(path).isFile();
    }

    List<String> getContentPaths() {
        List<String> pathsList = new ArrayList<>();
        if (currentFiles == null) {
            return pathsList;
        }
        for (File f : currentFiles) {
            pathsList.add(f.getAbsolutePath());
        }
        return pathsList;
    }

    String getFileSetName() {
        return "L01_FILE_SET_NAME";
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        fireChange();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        fireChange();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        fireChange();
    }

    @Messages({
        "L01Panel.moduleErr.name=Module Error",
        "L01Panel.moduleErr.msg=A module caused an error listening to L01Panel updates. See log to determine which module. Some data could be incomplete."
    })
    private void fireChange() {
        try {
            firePropertyChange(DataSourceProcessor.DSP_PANEL_EVENT.UPDATE_UI.toString(), false, true);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "L01Panel listener threw exception", e); //NON-NLS
            MessageNotifyUtil.Notify.show(NbBundle.getMessage(this.getClass(), "L01Panel.moduleErr"),
                    NbBundle.getMessage(this.getClass(), "L01Panel.moduleErr.msg"),
                    MessageNotifyUtil.MessageType.ERROR);
        }
    }
}
