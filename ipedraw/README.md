If you are writing a program that produces graphical output, you will
often use a window on your computer screen to display the result.  If
you want to share this output, for example, in a publication, a
screenshot will do the job -- but it will not look nice.  Instead, you
would like to have the output of your program in vector format;
preferable in a format that allows you to edit the output (in order to
add some annotation or change, say, colors or line widths).

The solution is simple: make your program write an XML-based Ipe file!
This gives you the possibility to open the file with Ipe, to modify
it, and to export it to a standard vector format such as pdf.

If your program happens to be written in Java, you can take advantage
of the small Java library [IpeDraw](IpeDraw.java) contributed by
Philipp Kindermann and Martin Fink.

Dongliang Peng has translated IpeDraw into language C#.
He is improving the C# version, [CIpeDraw](https://github.com/IGNF/ContinuousGeneralisation/blob/master/ContinuousGeneralizer/MorphingClass/CUtility/CIpeDraw.cs), 
from time to time.
