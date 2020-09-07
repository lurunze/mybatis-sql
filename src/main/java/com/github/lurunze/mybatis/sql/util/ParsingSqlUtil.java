package com.github.lurunze.mybatis.sql.util;

import static com.github.lurunze.mybatis.sql.util.StringConst.QUESTION_MARK;
import static org.apache.batik.svggen.SVGSyntax.CLOSE_PARENTHESIS;
import static org.apache.batik.svggen.SVGSyntax.COMMA;
import static org.apache.batik.svggen.SVGSyntax.OPEN_PARENTHESIS;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

/**
 * @author lurunze
 */
public class ParsingSqlUtil {

  private static final Set<String> NEED_QUOTATION_TYPE = new HashSet<>();
  static {
    NEED_QUOTATION_TYPE.add("String");
    NEED_QUOTATION_TYPE.add("Timestamp");
    NEED_QUOTATION_TYPE.add("Date");
    NEED_QUOTATION_TYPE.add("Time");
  }

  public static String parsingSql(String selectedText) {
    //only parsing the first Preparing and the first Parameters
    String[] logs = selectedText.split("\\n");
    String preparing = "";
    String parameters = "";
    boolean getPreparing = false;
    boolean getParameters = false;
    boolean hasParameters = false;
    for (String log : logs) {
      log = log.trim();
      if (log.contains(StringConst.PREPARING) && !getPreparing) {
        if (log.split(StringConst.PREPARING).length == 1) {
          return "preparing is empty";
        }
        preparing = log.split(StringConst.PREPARING)[1];
        getPreparing = true;
      }

      if (log.contains(StringConst.PARAMETERS) && !getParameters) {
        if (log.split(StringConst.PARAMETERS).length == 1) {
          break;
        }
        parameters = log.split(StringConst.PARAMETERS)[1];
        getParameters = true;
        hasParameters = true;
      }
    }
    if (!hasParameters) {
      return preparing;
    }

    String[] parameterArray = parameters.split(COMMA);
    int questionMarkCount = StringUtils.countMatches(preparing, QUESTION_MARK);
    if (parameterArray.length != questionMarkCount) {
      return "The number of '?' does not match the number of parameters";
    }

    StringBuilder sql = new StringBuilder();
    for (int i = 0, j = 0; i < preparing.length(); i++) {
      if (String.valueOf(preparing.charAt(i)).equals(QUESTION_MARK)) {
        sql.append(getParameter(parameterArray[j++]));
      } else {
        sql.append(preparing.charAt(i));
      }
    }
    return sql.toString();
  }

  private static String getParameter(String str) {
    int lastOpenParenthesisIndex = str.lastIndexOf(OPEN_PARENTHESIS);
    int lastCloseParenthesisIndex = str.lastIndexOf(CLOSE_PARENTHESIS);
    if (lastOpenParenthesisIndex > 0 && lastCloseParenthesisIndex > 0 && lastCloseParenthesisIndex > lastOpenParenthesisIndex) {
      String type = str.substring(lastOpenParenthesisIndex + 1, lastCloseParenthesisIndex);
      if (NEED_QUOTATION_TYPE.contains(type)) {
        return '\'' + str.substring(0, lastOpenParenthesisIndex).trim() + '\'';
      } else {
        return str.substring(0, lastOpenParenthesisIndex).trim();
      }
    }
    return str;
  }
}
