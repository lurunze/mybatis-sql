package com.github.lurunze.mybatis.sql.action;

import com.github.lurunze.mybatis.sql.util.ParsingSqlUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import org.apache.commons.lang.StringUtils;

/**
 * @author lurunze
 */
public class CopyAsSqlAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {
    Editor editor = e.getData(PlatformDataKeys.EDITOR);
    SelectionModel selectionModel = editor.getSelectionModel();
    String selectedText = selectionModel.getSelectedText();
    if (StringUtils.isBlank(selectedText)) {
      return;
    }
    String sql = ParsingSqlUtil.parsingSql(selectedText);
    Transferable trans = new StringSelection(sql);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
  }
}
