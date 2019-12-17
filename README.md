# FCIH_Parallel_Fall2019_prefixsum_20160073


Asmaa Mohammed AbdElRahim frrag 20160073 .. اسماء محمد عبدالرحيم فراج
Eman AbdElfattah attia AbdElfattah 20160095 ..ايمان عبدالفتاح عطية 
Mariam said bayoumi Ali 20160418 .. مريم سعيد بيومي

Algorithm :

work-efficient parallel prefix sum as following : 1_Compute the sums of consecutive pairs of the input array z0 = x0 + x1, z1 = x2 + x3 2_ compute the prefix sum Recursively 3_Express each term of the final sequence y0, y1, y2, ... as the sum of up to two terms of these intermediate sequences: y0 = x0, y1 = z0, y2 = z0 + x2, y3 = w0, etc. After the first value, each successive number yi is either copied from a position half as far through the w sequence, or is the previous value added to one value in the x sequence.
