package com.github.lurunze.mybatis.sql.dialog;

import static com.github.lurunze.mybatis.sql.util.StringConst.PLUGIN_NAME;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.jetbrains.annotations.Nullable;

/**
 * @author lurunze
 */
public class SqlDialog extends DialogWrapper {

  private final String sql;

  private JPanel panel;

  public SqlDialog(@Nullable String sql) {
    super(true);
    setTitle(PLUGIN_NAME);
    this.sql = sql;
    init();
  }

  @Override
  protected @Nullable JComponent createCenterPanel() {
    panel = new JPanel(new BorderLayout());
    JTextArea textArea = new JTextArea(sql);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setOpaque(false);
    textArea.setEditable(false);
    JBScrollPane scroll = new JBScrollPane(textArea);
    panel.add(scroll, BorderLayout.CENTER);
    panel.setPreferredSize(new Dimension(600, 371));
    return panel;
  }

  @Override
  protected JComponent createSouthPanel() {
    JPanel southPanel = new JPanel(new FlowLayout());
    JButton button = new JButton("Copy to Clipboard");
    button.addActionListener(e -> {
      Transferable trans = new StringSelection(sql);
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
      panel.setVisible(false);
      dispose();
    });
    southPanel.add(button);
    return southPanel;
  }
}
