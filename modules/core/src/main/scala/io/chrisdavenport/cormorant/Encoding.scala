package io.chrisdavenport.cormorant

object Encoding {
  def encodeWithHeaders[A: Write](xs: List[A], headers: CSV.Headers): CSV.Complete =
    CSV.Complete(headers, encodeRows(xs))
  def encodeRows[A: Write](xs: List[A]): CSV.Rows = CSV.Rows(xs.map(Write[A].write))

  def encode[A: LabelledWrite](xs: List[A]): CSV.Complete =
    CSV.Complete(LabelledWrite[A].headers, CSV.Rows(xs.map(LabelledWrite[A].write)))
}