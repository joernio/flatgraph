package flatgraph.help

import Table.*

case class Table(columnNames: Seq[String], rows: Seq[Row]) {

  def render(implicit availableWidthProvider: AvailableWidthProvider): String = {
    if (columnNames.isEmpty && rows.isEmpty) {
      ""
    } else {
      val renderingWidth = math.max(availableWidthProvider.apply(), 60)
      val minWidth       = 1
      val maxWidth       = renderingWidth - minWidth
      val allRows        = columnNames +: rows
      val numCols        = columnNames.size

      // calculate column widths: longest content per column, clamped to [minWidth, maxWidth]
      val colWidths = (0 until numCols).map { col =>
        val longest = allRows.map(row => if (col < row.size) row(col).length else 0).max
        math.min(math.max(longest, minWidth), maxWidth)
      }

      val sb = new StringBuilder()
      sb.append(horizontalRule('┌', '┬', '┐', colWidths))
      sb.append('\n')
      appendRow(sb, columnNames, colWidths)
      sb.append(horizontalRule('├', '┼', '┤', colWidths))
      sb.append('\n')
      if (rows.nonEmpty) {
        rows.foreach(row => appendRow(sb, row, colWidths))
      }
      sb.append(horizontalRule('└', '┴', '┘', colWidths))
      sb.toString()
    }
  }

  private def horizontalRule(left: Char, mid: Char, right: Char, colWidths: Seq[Int]): String = {
    colWidths.map("─" * _).mkString(left.toString, mid.toString, right.toString)
  }

  private def appendRow(sb: StringBuilder, row: Seq[String], colWidths: Seq[Int]): Unit = {
    val wrappedCols = colWidths.indices.map { col =>
      val content = if (col < row.size) row(col) else ""
      wordWrap(content, colWidths(col))
    }
    val maxLines = wrappedCols.map(_.size).max
    for (line <- 0 until maxLines) {
      sb.append('│')
      for (col <- colWidths.indices) {
        val text = if (line < wrappedCols(col).size) wrappedCols(col)(line) else ""
        sb.append(text)
        sb.append(" " * (colWidths(col) - text.length))
        sb.append('│')
      }
      sb.append('\n')
    }
  }

  private def wordWrap(text: String, width: Int): Seq[String] = {
    if (text.length <= width) {
      return Seq(text)
    }
    val words   = text.split(" ", -1)
    val lines   = Seq.newBuilder[String]
    val current = new StringBuilder()
    for (word <- words) {
      if (current.isEmpty) {
        current.append(word)
      } else if (current.length + 1 + word.length > width) {
        lines += current.toString()
        current.clear()
        current.append(word)
      } else {
        current.append(' ')
        current.append(word)
      }
    }
    if (current.nonEmpty) {
      lines += current.toString()
    }
    lines.result()
  }
}

object Table {
  type Row = Seq[String]

  trait AvailableWidthProvider extends (() => Int)

  class ConstantWidth(width: Int) extends AvailableWidthProvider {
    override def apply() = width
  }

}
