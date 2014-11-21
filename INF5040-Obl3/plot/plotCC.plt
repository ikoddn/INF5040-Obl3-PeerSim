# You can uncomment the following lines to produce a png figure
#set terminal png enhanced
#set output 'plot.png'

set title "Average Clustering Coefficient"
set xlabel "cycles"
set ylabel "clustering coefficient (log)"
set key right top
set logscale y 
plot "output-clustering.txt" title 'Random Graph c = 30' with lines