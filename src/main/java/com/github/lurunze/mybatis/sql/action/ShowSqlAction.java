package com.github.lurunze.mybatis.sql.action;

import com.github.lurunze.mybatis.sql.dialog.SqlDialog;
import com.github.lurunze.mybatis.sql.util.ParsingSqlUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.commons.lang.StringUtils;

/**
 * @author lurunze
 */
public class ShowSqlAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {

    Editor editor = e.getData(PlatformDataKeys.EDITOR);
    SelectionModel selectionModel = editor.getSelectionModel();
    String selectedText = selectionModel.getSelectedText();
    if (StringUtils.isBlank(selectedText)) {
      return;
    }
    String sql = ParsingSqlUtil.parsingSql(selectedText);
    SqlDialog dialog = new SqlDialog(sql);
    dialog.show();
  }
}
