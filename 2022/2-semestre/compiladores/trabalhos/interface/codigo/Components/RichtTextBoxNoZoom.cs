namespace Interface.Components
{
    public class RichtTextBoxNoZoom : RichTextBox
    {
        private const int MK_CONTROL = 0x0008;
        private const int WM_MOUSEWHEEL = 0x020A;

        public RichtTextBoxNoZoom() { }

        protected override void DefWndProc(ref Message m)
        {
            if (m.Msg == WM_MOUSEWHEEL && Control.ModifierKeys == Keys.Control)
            {
                // Do what you want here            
            }
            else
            {
                base.DefWndProc(ref m);
            }
        }
    }
}
