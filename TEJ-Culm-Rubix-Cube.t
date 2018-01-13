setscreen ("graphics:800;600")

Draw.FillBox (0, 0, 800, 600, 90)

Draw.FillBox (700, 500, 800, 600, 0)
var font := Font.New ("arial:12")
Draw.Text ("Send State", 710, 550, font, 7);
Draw.Box (700, 500, 800, 600, 7)

var x : array 1 .. 4 of int := init (50, 200, 350, 200)
var y : array 1 .. 4 of int := init (400, 500, 400, 300)
Draw.FillPolygon (x, y, 4, yellow)
Draw.Polygon (x, y, 4, black)
var x2 : array 1 .. 4 of int := init (50, 50, 200, 200)
var y2 : array 1 .. 4 of int := init (400, 220, 120, 300)
Draw.FillPolygon (x2, y2, 4, brightred)
Draw.Polygon (x2, y2, 4, black)
var x3 : array 1 .. 4 of int := init (350, 350, 200, 200)
var y3 : array 1 .. 4 of int := init (400, 220, 120, 300)
Draw.FillPolygon (x3, y3, 4, green)
Draw.Polygon (x3, y3, 4, black)

var x4 : array 1 .. 4 of int := init (150, 200, 250, 200)
var y4 : array 1 .. 4 of int := init (466, 500, 466, 433)
Draw.FillPolygon (x4, y4, 4, cyan)
Draw.Polygon (x4, y4, 4, black)

Draw.Line (150, 466, 300, 366, 1)
Draw.Line (100, 433, 250, 333, 1)
Draw.Line (100, 366, 250, 466, 1)
Draw.Line (150, 333, 300, 433, 1)
Draw.Line (100, 366, 100, 186, 1)
Draw.Line (150, 333, 150, 333 - 180, 1)
Draw.Line (300, 366, 300, 186, 1)
Draw.Line (250, 333, 250, 333 - 180, 1)
Draw.Line (50, 340, 200, 240, 1)
Draw.Line (50, 280, 200, 180, 1)
Draw.Line (350, 340, 200, 240, 1)
Draw.Line (350, 280, 200, 180, 1)
Draw.Box (195, 460, 205, 470, black)

function getLines (fileName : string) : int
    var f, numLines : int
    var line : string
    open : f, fileName, get
    numLines := 0
    loop
	exit when eof (f)
	get : f, line : *
	numLines += 1
    end loop
    close : f
    result numLines
end getLines

procedure readFile (var lines : array 1 .. * of string, fileName : string)
    var f : int
    var line : string
    open : f, fileName, get
    for i : 1 .. upper (lines)
	get : f, lines (i) : *
    end for
    close : f
end readFile

%var lines : flexible array 1 .. 0 of string
%new lines, getLines ("coord.txt")
%readFile (lines, "coord.txt")
%for i : 1 .. upper (lines)
%    put lines (i)
%end for


var a, b, button : int
var bounce : boolean
bounce := true
var slope : real
slope := 34 / 50.0
var slope2 : real
slope2 := 100 / 150.0
var yellowFaceX : array 1 .. 3, 1 .. 3, 1 .. 4 of int
var yellowFaceY : array 1 .. 3, 1 .. 3, 1 .. 4 of int
var redFaceX : array 1 .. 3, 1 .. 3, 1 .. 4 of int
var redFaceY : array 1 .. 3, 1 .. 3, 1 .. 4 of int
var greenFaceX : array 1 .. 3, 1 .. 3, 1 .. 4 of int
var greenFaceY : array 1 .. 3, 1 .. 3, 1 .. 4 of int
%yellowFaceX (1,2) := init (150, 200, 250, 200)
var pointsX : array 1 .. 7 of int := init (50, 100, 150, 200, 250, 300, 350)
var pointsY : array 1 .. 7 of int := init (300, 333, 366, 400, 433, 466, 500)
var xVal : int
var yVal : int

for i : 1 .. 3
    for j : 1 .. 3
	for k : 1 .. 4
	    if (i = j) then
		if (k mod 2 = 1) then
		    xVal := pointsX (4)
		elsif (k = 2) then
		    xVal := pointsX (5)
		else
		    xVal := pointsX (3)
		end if
	    elsif (j - i = 1) then
		if (k mod 2 = 1) then
		    xVal := pointsX (5)
		elsif (k = 2) then
		    xVal := pointsX (6)
		else
		    xVal := pointsX (4)
		end if
	    elsif (i - j = 1) then
		if (k mod 2 = 1) then
		    xVal := pointsX (3)
		elsif (k = 2) then
		    xVal := pointsX (4)
		else
		    xVal := pointsX (2)
		end if
	    elsif (i = 3 and j = 1) then
		if (k mod 2 = 1) then
		    xVal := pointsX (2)
		elsif (k = 2) then
		    xVal := pointsX (3)
		else
		    xVal := pointsX (1)
		end if
	    else
		if (k mod 2 = 1) then
		    xVal := pointsX (6)
		elsif (k = 2) then
		    xVal := pointsX (7)
		else
		    xVal := pointsX (5)
		end if
	    end if
	    yellowFaceX (i, j, k) := xVal
	end for
    end for
end for

for i : 1 .. 3
    for j : 1 .. 3
	for k : 1 .. 4
	    if (i + j = 4) then
		if (k mod 2 = 0) then
		    yVal := pointsY (4)
		elsif (k = 1) then
		    yVal := pointsY (5)
		else
		    yVal := pointsY (3)
		end if
	    elsif (i + j = 3) then
		if (k mod 2 = 0) then
		    yVal := pointsY (5)
		elsif (k = 1) then
		    yVal := pointsY (6)
		else
		    yVal := pointsY (4)
		end if
	    elsif (i + j = 5) then
		if (k mod 2 = 0) then
		    yVal := pointsY (3)
		elsif (k = 1) then
		    yVal := pointsY (4)
		else
		    yVal := pointsY (2)
		end if
	    elsif (i = 3 and j = 3) then
		if (k mod 2 = 0) then
		    yVal := pointsY (2)
		elsif (k = 1) then
		    yVal := pointsY (3)
		else
		    yVal := pointsY (1)
		end if
	    else
		if (k mod 2 = 0) then
		    yVal := pointsY (6)
		elsif (k = 1) then
		    yVal := pointsY (7)
		else
		    yVal := pointsY (5)
		end if
	    end if
	    yellowFaceY (i, j, k) := yVal
	end for
    end for
end for

for i : 1 .. 3
    for j : 1 .. 3
	for k : 1 .. 4
	    if (j = 1) then
		if (k < 3) then
		    xVal := pointsX (1)
		else
		    xVal := pointsX (2)
		end if
	    elsif (j = 2) then
		if (k < 3) then
		    xVal := pointsX (2)
		else
		    xVal := pointsX (3)
		end if
	    else
		if (k < 3) then
		    xVal := pointsX (3)
		else
		    xVal := pointsX (4)
		end if
	    end if
	    redFaceX (i, j, k) := xVal
	end for
    end for
end for

for i : 1 .. 3
    for j : 1 .. 3
	for k : 1 .. 4
	    if (j = 1) then
		if (k < 3) then
		    yVal := pointsY(4)-60*(i-1)-60*(k-1)
		else
		    yVal := pointsY(3)-60*(i-1)+60*(k-4)
		end if
	    elsif (j = 2) then
		if (k < 3) then
		    yVal := pointsY(3)-60*(i-1)-60*(k-1)
		else
		    yVal := pointsY(2)-60*(i-1)+60*(k-4)
		end if
	    else
		if (k < 3) then
		    yVal := pointsY(2)-60*(i-1)-60*(k-1)
		else
		    yVal := pointsY(1)-60*(i-1)+60*(k-4)
		end if
	    end if
	    redFaceY (i, j, k) := yVal
	end for
    end for
end for

for i : 1 .. 3
    for j : 1 .. 3
	for k : 1 .. 4
	    if (j = 1) then
		if (k < 3) then
		    xVal := pointsX (4)
		else
		    xVal := pointsX (5)
		end if
	    elsif (j = 2) then
		if (k < 3) then
		    xVal := pointsX (5)
		else
		    xVal := pointsX (6)
		end if
	    else
		if (k < 3) then
		    xVal := pointsX (6)
		else
		    xVal := pointsX (7)
		end if
	    end if
	    greenFaceX (i, j, k) := xVal
	end for
    end for
end for

for i : 1 .. 3
    for j : 1 .. 3
	for k : 1 .. 4
	    if (j = 1) then
		if (k < 3) then
		    yVal := pointsY(4)-60*(i-1)-60*(k-1)
		else
		    yVal := pointsY(5)-60*(i-1)+60*(k-4)
		end if
	    elsif (j = 2) then
		if (k < 3) then
		    yVal := pointsY(5)-60*(i-1)-60*(k-1)
		else
		    yVal := pointsY(6)-60*(i-1)+60*(k-4)
		end if
	    else
		if (k < 3) then
		    yVal := pointsY(6)-60*(i-1)-60*(k-1)
		else
		    yVal := pointsY(7)-60*(i-1)+60*(k-4)
		end if
	    end if
	    greenFaceY (i, j, k) := yVal-100 %lol i messed up the logic here somewhere so i used -100 to fix
	end for
    end for
end for

var gx1 : array 1 .. 4 of int
var gx2 : array 1 .. 4 of int
var gx3 : array 1 .. 4 of int
var gx4 : array 1 .. 4 of int
var gx5 : array 1 .. 4 of int
var gx6 : array 1 .. 4 of int
var gx7 : array 1 .. 4 of int
var gx8 : array 1 .. 4 of int
var gx9 : array 1 .. 4 of int

var gy1 : array 1 .. 4 of int
var gy2 : array 1 .. 4 of int
var gy3 : array 1 .. 4 of int
var gy4 : array 1 .. 4 of int
var gy5 : array 1 .. 4 of int
var gy6 : array 1 .. 4 of int
var gy7 : array 1 .. 4 of int
var gy8 : array 1 .. 4 of int
var gy9 : array 1 .. 4 of int

var rx1 : array 1 .. 4 of int
var rx2 : array 1 .. 4 of int
var rx3 : array 1 .. 4 of int
var rx4 : array 1 .. 4 of int
var rx5 : array 1 .. 4 of int
var rx6 : array 1 .. 4 of int
var rx7 : array 1 .. 4 of int
var rx8 : array 1 .. 4 of int
var rx9 : array 1 .. 4 of int

var ry1 : array 1 .. 4 of int
var ry2 : array 1 .. 4 of int
var ry3 : array 1 .. 4 of int
var ry4 : array 1 .. 4 of int
var ry5 : array 1 .. 4 of int
var ry6 : array 1 .. 4 of int
var ry7 : array 1 .. 4 of int
var ry8 : array 1 .. 4 of int
var ry9 : array 1 .. 4 of int

var wx1 : array 1 .. 4 of int
var wx2 : array 1 .. 4 of int
var wx3 : array 1 .. 4 of int
var wx4 : array 1 .. 4 of int
var wx5 : array 1 .. 4 of int
var wx6 : array 1 .. 4 of int
var wx7 : array 1 .. 4 of int
var wx8 : array 1 .. 4 of int
var wx9 : array 1 .. 4 of int

var wy1 : array 1 .. 4 of int
var wy2 : array 1 .. 4 of int
var wy3 : array 1 .. 4 of int
var wy4 : array 1 .. 4 of int
var wy5 : array 1 .. 4 of int
var wy6 : array 1 .. 4 of int
var wy7 : array 1 .. 4 of int
var wy8 : array 1 .. 4 of int
var wy9 : array 1 .. 4 of int

var bx1 : array 1 .. 4 of int
var bx2 : array 1 .. 4 of int
var bx3 : array 1 .. 4 of int
var bx4 : array 1 .. 4 of int
var bx5 : array 1 .. 4 of int
var bx6 : array 1 .. 4 of int
var bx7 : array 1 .. 4 of int
var bx8 : array 1 .. 4 of int
var bx9 : array 1 .. 4 of int

var by1 : array 1 .. 4 of int
var by2 : array 1 .. 4 of int
var by3 : array 1 .. 4 of int
var by4 : array 1 .. 4 of int
var by5 : array 1 .. 4 of int
var by6 : array 1 .. 4 of int
var by7 : array 1 .. 4 of int
var by8 : array 1 .. 4 of int
var by9 : array 1 .. 4 of int

var ox1 : array 1 .. 4 of int
var ox2 : array 1 .. 4 of int
var ox3 : array 1 .. 4 of int
var ox4 : array 1 .. 4 of int
var ox5 : array 1 .. 4 of int
var ox6 : array 1 .. 4 of int
var ox7 : array 1 .. 4 of int
var ox8 : array 1 .. 4 of int
var ox9 : array 1 .. 4 of int

var oy1 : array 1 .. 4 of int
var oy2 : array 1 .. 4 of int
var oy3 : array 1 .. 4 of int
var oy4 : array 1 .. 4 of int
var oy5 : array 1 .. 4 of int
var oy6 : array 1 .. 4 of int
var oy7 : array 1 .. 4 of int
var oy8 : array 1 .. 4 of int
var oy9 : array 1 .. 4 of int

var x1 : array 1 .. 4 of int
var x5 : array 1 .. 4 of int
var x6 : array 1 .. 4 of int
var x7 : array 1 .. 4 of int
var x8 : array 1 .. 4 of int
var x9 : array 1 .. 4 of int

var y1 : array 1 .. 4 of int
var y5 : array 1 .. 4 of int
var y6 : array 1 .. 4 of int
var y7 : array 1 .. 4 of int
var y8 : array 1 .. 4 of int
var y9 : array 1 .. 4 of int

for k : 1 .. 4
    x1(k) := yellowFaceX(1,1,k)
    x2(k) := yellowFaceX(1,2,k)
    x3(k) := yellowFaceX(1,3,k)
    x4(k) := yellowFaceX(2,1,k)
    x5(k) := yellowFaceX(2,2,k)
    x6(k) := yellowFaceX(2,3,k)
    x7(k) := yellowFaceX(3,1,k)
    x8(k) := yellowFaceX(3,2,k)
    x9(k) := yellowFaceX(3,3,k)
    y1(k) := yellowFaceY(1,1,k)
    y2(k) := yellowFaceY(1,2,k)
    y3(k) := yellowFaceY(1,3,k)
    y4(k) := yellowFaceY(2,1,k)
    y5(k) := yellowFaceY(2,2,k)
    y6(k) := yellowFaceY(2,3,k)
    y7(k) := yellowFaceY(3,1,k)
    y8(k) := yellowFaceY(3,2,k)
    y9(k) := yellowFaceY(3,3,k)
    rx1(k) := redFaceX(1,1,k)
    rx2(k) := redFaceX(1,2,k)
    rx3(k) := redFaceX(1,3,k)
    rx4(k) := redFaceX(2,1,k)
    rx5(k) := redFaceX(2,2,k)
    rx6(k) := redFaceX(2,3,k)
    rx7(k) := redFaceX(3,1,k)
    rx8(k) := redFaceX(3,2,k)
    rx9(k) := redFaceX(3,3,k)
    ry1(k) := redFaceY(1,1,k)
    ry2(k) := redFaceY(1,2,k)
    ry3(k) := redFaceY(1,3,k)
    ry4(k) := redFaceY(2,1,k)
    ry5(k) := redFaceY(2,2,k)
    ry6(k) := redFaceY(2,3,k)
    ry7(k) := redFaceY(3,1,k)
    ry8(k) := redFaceY(3,2,k)
    ry9(k) := redFaceY(3,3,k)
    gx1(k) := greenFaceX(1,1,k)
    gx2(k) := greenFaceX(1,2,k)
    gx3(k) := greenFaceX(1,3,k)
    gx4(k) := greenFaceX(2,1,k)
    gx5(k) := greenFaceX(2,2,k)
    gx6(k) := greenFaceX(2,3,k)
    gx7(k) := greenFaceX(3,1,k)
    gx8(k) := greenFaceX(3,2,k)
    gx9(k) := greenFaceX(3,3,k)
    gy1(k) := greenFaceY(1,1,k)
    gy2(k) := greenFaceY(1,2,k)
    gy3(k) := greenFaceY(1,3,k)
    gy4(k) := greenFaceY(2,1,k)
    gy5(k) := greenFaceY(2,2,k)
    gy6(k) := greenFaceY(2,3,k)
    gy7(k) := greenFaceY(3,1,k)
    gy8(k) := greenFaceY(3,2,k)
    gy9(k) := greenFaceY(3,3,k)
    wx1(k) := x1(k)+400
    wx2(k) := x2(k)+400
    wx3(k) := x3(k)+400
    wx4(k) := x4(k)+400
    wx5(k) := x5(k)+400
    wx6(k) := x6(k)+400
    wx7(k) := x7(k)+400
    wx8(k) := x8(k)+400
    wx9(k) := x9(k)+400
    wy1(k) := y1(k)
    wy2(k) := y2(k)
    wy3(k) := y3(k)
    wy4(k) := y4(k)
    wy5(k) := y5(k)
    wy6(k) := y6(k)
    wy7(k) := y7(k)
    wy8(k) := y8(k)
    wy9(k) := y9(k)
    bx1(k) := rx1(k)+400
    bx2(k) := rx2(k)+400
    bx3(k) := rx3(k)+400
    bx4(k) := rx4(k)+400
    bx5(k) := rx5(k)+400
    bx6(k) := rx6(k)+400
    bx7(k) := rx7(k)+400
    bx8(k) := rx8(k)+400
    bx9(k) := rx9(k)+400
    by1(k) := ry1(k)
    by2(k) := ry2(k)
    by3(k) := ry3(k)
    by4(k) := ry4(k)
    by5(k) := ry5(k)
    by6(k) := ry6(k)
    by7(k) := ry7(k)
    by8(k) := ry8(k)
    by9(k) := ry9(k)
    ox1(k) := gx1(k)+400
    ox2(k) := gx2(k)+400
    ox3(k) := gx3(k)+400
    ox4(k) := gx4(k)+400
    ox5(k) := gx5(k)+400
    ox6(k) := gx6(k)+400
    ox7(k) := gx7(k)+400
    ox8(k) := gx8(k)+400
    ox9(k) := gx9(k)+400
    oy1(k) := gy1(k)
    oy2(k) := gy2(k)
    oy3(k) := gy3(k)
    oy4(k) := gy4(k)
    oy5(k) := gy5(k)
    oy6(k) := gy6(k)
    oy7(k) := gy7(k)
    oy8(k) := gy8(k)
    oy9(k) := gy9(k)
end for

var bottomTop : array 0 .. 2 of int
var bottomMid : array 0 .. 2 of int
var bottomBot : array 0 .. 2 of int
var backTop : array 0 .. 2 of int
var backMid : array 0 .. 2 of int
var backBot : array 0 .. 2 of int
var rightTop : array 0 .. 2 of int
var rightMid : array 0 .. 2 of int
var rightBot : array 0 .. 2 of int
var frontTop : array 0 .. 2 of int
var frontMid : array 0 .. 2 of int
var frontBot : array 0 .. 2 of int
var leftTop : array 0 .. 2 of int
var leftMid : array 0 .. 2 of int
var leftBot : array 0 .. 2 of int
var topTop : array 0 .. 2 of int
var topMid : array 0 .. 2 of int
var topBot : array 0 .. 2 of int
var temp : int

for i : 0 .. 2
    bottomTop (i) := 0
    bottomMid (i) := 0
    bottomBot (i) := 0
    backTop (i) := 1
    backMid (i) := 1
    backBot (i) := 1
    rightTop (i) := 2
    rightMid (i) := 2
    rightBot (i) := 2
    frontTop (i) := 3
    frontMid (i) := 3
    frontBot (i) := 3
    leftTop (i) := 4
    leftMid (i) := 4
    leftBot (i) := 4
    topTop (i) := 5
    topMid (i) := 5
    topBot (i) := 5
end for

function getVal (temp : int) : int
    if temp = 0 then
	result 0
    elsif (temp = 1) then
	result 42
    elsif (temp = 2) then
	result 10
    elsif (temp = 3) then
	result 12
    elsif (temp = 4) then
	result 9
    elsif (temp = 5) then
	result 14
    end if
end getVal

procedure drawBoard ()
    Draw.FillPolygon (x1, y1, 4, getVal(topTop(0)))
    Draw.Polygon (x1, y1, 4, black)
    Draw.FillPolygon (x2, y2, 4, getVal(topTop(1)))
    Draw.Polygon (x2, y2, 4, black)
    Draw.FillPolygon (x3, y3, 4, getVal(topTop(2)))
    Draw.Polygon (x3, y3, 4, black)
    Draw.FillPolygon (x4, y4, 4, getVal(topMid(0)))
    Draw.Polygon (x4, y4, 4, black)
    Draw.FillPolygon (x5, y5, 4, getVal(topMid(1)))
    Draw.Polygon (x5, y5, 4, black)
    Draw.FillPolygon (x6, y6, 4, getVal(topMid(2)))
    Draw.Polygon (x6, y6, 4, black)
    Draw.FillPolygon (x7, y7, 4, getVal(topBot(0)))
    Draw.Polygon (x7, y7, 4, black)
    Draw.FillPolygon (x8, y8, 4, getVal(topBot(1)))
    Draw.Polygon (x8, y8, 4, black)
    Draw.FillPolygon (x9, y9, 4, getVal(topBot(2)))
    Draw.Polygon (x9, y9, 4, black)
    Draw.FillPolygon (rx1, ry1, 4, getVal(frontTop(0)))
    Draw.Polygon (rx1, ry1, 4, black)
    Draw.FillPolygon (rx2, ry2, 4, getVal(frontTop(1)))
    Draw.Polygon (rx2, ry2, 4, black)
    Draw.FillPolygon (rx3, ry3, 4, getVal(frontTop(2)))
    Draw.Polygon (rx3, ry3, 4, black)
    Draw.FillPolygon (rx4, ry4, 4, getVal(frontMid(0)))
    Draw.Polygon (rx4, ry4, 4, black)
    Draw.FillPolygon (rx5, ry5, 4, getVal(frontMid(1)))
    Draw.Polygon (rx5, ry5, 4, black)
    Draw.FillPolygon (rx6, ry6, 4, getVal(frontMid(2)))
    Draw.Polygon (rx6, ry6, 4, black)
    Draw.FillPolygon (rx7, ry7, 4, getVal(frontBot(0)))
    Draw.Polygon (rx7, ry7, 4, black)
    Draw.FillPolygon (rx8, ry8, 4, getVal(frontBot(1)))
    Draw.Polygon (rx8, ry8, 4, black)
    Draw.FillPolygon (rx9, ry9, 4, getVal(frontBot(2)))
    Draw.Polygon (rx9, ry9, 4, black)
    Draw.FillPolygon (gx1, gy1, 4, getVal(rightTop(0)))
    Draw.Polygon (gx1, gy1, 4, black)
    Draw.FillPolygon (gx2, gy2, 4, getVal(rightTop(1)))
    Draw.Polygon (gx2, gy2, 4, black)
    Draw.FillPolygon (gx3, gy3, 4, getVal(rightTop(2)))
    Draw.Polygon (gx3, gy3, 4, black)
    Draw.FillPolygon (gx4, gy4, 4, getVal(rightMid(0)))
    Draw.Polygon (gx4, gy4, 4, black)
    Draw.FillPolygon (gx5, gy5, 4, getVal(rightMid(1)))
    Draw.Polygon (gx5, gy5, 4, black)
    Draw.FillPolygon (gx6, gy6, 4, getVal(rightMid(2)))
    Draw.Polygon (gx6, gy6, 4, black)
    Draw.FillPolygon (gx7, gy7, 4, getVal(rightBot(0)))
    Draw.Polygon (gx7, gy7, 4, black)
    Draw.FillPolygon (gx8, gy8, 4, getVal(rightBot(1)))
    Draw.Polygon (gx8, gy8, 4, black)
    Draw.FillPolygon (gx9, gy9, 4, getVal(rightBot(2)))
    Draw.Polygon (gx9, gy9, 4, black)
    Draw.FillPolygon (wx1, wy1, 4, getVal(bottomTop(2)))
    Draw.Polygon (wx1, wy1, 4, black)
    Draw.FillPolygon (wx2, wy2, 4, getVal(bottomMid(2)))
    Draw.Polygon (wx2, wy2, 4, black)
    Draw.FillPolygon (wx3, wy3, 4, getVal(bottomBot(2)))
    Draw.Polygon (wx3, wy3, 4, black)
    Draw.FillPolygon (wx4, wy4, 4, getVal(bottomTop(1)))
    Draw.Polygon (wx4, wy4, 4, black)
    Draw.FillPolygon (wx5, wy5, 4, getVal(bottomMid(1)))
    Draw.Polygon (wx5, wy5, 4, black)
    Draw.FillPolygon (wx6, wy6, 4, getVal(bottomBot(1)))
    Draw.Polygon (wx6, wy6, 4, black)
    Draw.FillPolygon (wx7, wy7, 4, getVal(bottomTop(0)))
    Draw.Polygon (wx7, wy7, 4, black)
    Draw.FillPolygon (wx8, wy8, 4, getVal(bottomMid(0)))
    Draw.Polygon (wx8, wy8, 4, black)
    Draw.FillPolygon (wx9, wy9, 4, getVal(bottomBot(0)))
    Draw.Polygon (wx9, wy9, 4, black)
    Draw.FillPolygon (bx1, by1, 4, getVal(leftBot(2)))
    Draw.Polygon (bx1, by1, 4, black)
    Draw.FillPolygon (bx2, by2, 4, getVal(leftBot(1)))
    Draw.Polygon (bx2, by2, 4, black)
    Draw.FillPolygon (bx3, by3, 4, getVal(leftBot(0)))
    Draw.Polygon (bx3, by3, 4, black)
    Draw.FillPolygon (bx4, by4, 4, getVal(leftMid(2)))
    Draw.Polygon (bx4, by4, 4, black)
    Draw.FillPolygon (bx5, by5, 4, getVal(leftMid(1)))
    Draw.Polygon (bx5, by5, 4, black)
    Draw.FillPolygon (bx6, by6, 4, getVal(leftMid(0)))
    Draw.Polygon (bx6, by6, 4, black)
    Draw.FillPolygon (bx7, by7, 4, getVal(leftTop(2)))
    Draw.Polygon (bx7, by7, 4, black)
    Draw.FillPolygon (bx8, by8, 4, getVal(leftTop(1)))
    Draw.Polygon (bx8, by8, 4, black)
    Draw.FillPolygon (bx9, by9, 4, getVal(leftTop(0)))
    Draw.Polygon (bx9, by9, 4, black)
    Draw.FillPolygon (ox1, oy1, 4, getVal(backBot(2)))
    Draw.Polygon (ox1, oy1, 4, black)
    Draw.FillPolygon (ox2, oy2, 4, getVal(backBot(1)))
    Draw.Polygon (ox2, oy2, 4, black)
    Draw.FillPolygon (ox3, oy3, 4, getVal(backBot(0)))
    Draw.Polygon (ox3, oy3, 4, black)
    Draw.FillPolygon (ox4, oy4, 4, getVal(backMid(2)))
    Draw.Polygon (ox4, oy4, 4, black)
    Draw.FillPolygon (ox5, oy5, 4, getVal(backMid(1)))
    Draw.Polygon (ox5, oy5, 4, black)
    Draw.FillPolygon (ox6, oy6, 4, getVal(backMid(0)))
    Draw.Polygon (ox6, oy6, 4, black)
    Draw.FillPolygon (ox7, oy7, 4, getVal(backTop(2)))
    Draw.Polygon (ox7, oy7, 4, black)
    Draw.FillPolygon (ox8, oy8, 4, getVal(backTop(1)))
    Draw.Polygon (ox8, oy8, 4, black)
    Draw.FillPolygon (ox9, oy9, 4, getVal(backTop(0)))
    Draw.Polygon (ox9, oy9, 4, black)
end drawBoard

var first : boolean
first := true
%arrys begin at 1 lol
loop
    if (first) then
	drawBoard ()
	first := false
    end if
    Mouse.Where (a, b, button)
    if (button = 1) then
	if (bounce) then
	    if (a > 700 and b > 500) then
		exit
	    elsif (b < -slope * abs (yellowFaceX (1, 1, 1) - a) + yellowFaceY (1, 1, 1) and b > slope * abs (yellowFaceX (1, 1, 3) - a) + yellowFaceY (1, 1, 3)) then
		topTop (0) := (topTop (0) + 1) mod 6
	    elsif (b < -slope * abs (yellowFaceX (1, 2, 1) - a) + yellowFaceY (1, 2, 1) and b > slope * abs (yellowFaceX (1, 2, 3) - a) + yellowFaceY (1, 2, 3)) then
		topTop (1) := (topTop (1) + 1) mod 6
	    elsif (b < -slope * abs (yellowFaceX (1, 3, 1) - a) + yellowFaceY (1, 3, 1) and b > slope * abs (yellowFaceX (1, 3, 3) - a) + yellowFaceY (1, 3, 3)) then
		topTop (2) := (topTop (2) + 1) mod 6
	    elsif (b < -slope * abs (yellowFaceX (2, 1, 1) - a) + yellowFaceY (2, 1, 1) and b > slope * abs (yellowFaceX (2, 1, 3) - a) + yellowFaceY (2, 1, 3)) then
		topMid (0) := (topMid (0) + 1) mod 6
	    elsif (b < -slope * abs (yellowFaceX (2, 3, 1) - a) + yellowFaceY (2, 3, 1) and b > slope * abs (yellowFaceX (2, 3, 3) - a) + yellowFaceY (2, 3, 3)) then
		topMid (2) := (topMid (2) + 1) mod 6
	    elsif (b < -slope * abs (yellowFaceX (3, 1, 1) - a) + yellowFaceY (3, 1, 1) and b > slope * abs (yellowFaceX (3, 1, 3) - a) + yellowFaceY (3, 1, 3)) then
		topBot (0) := (topBot (0) + 1) mod 6
	    elsif (b < -slope * abs (yellowFaceX (3, 2, 1) - a) + yellowFaceY (3, 2, 1) and b > slope * abs (yellowFaceX (3, 2, 3) - a) + yellowFaceY (3, 2, 3)) then
		topBot (1) := (topBot (1) + 1) mod 6
	    elsif (b < -slope * abs (yellowFaceX (3, 3, 1) - a) + yellowFaceY (3, 3, 1) and b > slope * abs (yellowFaceX (3, 3, 3) - a) + yellowFaceY (3, 3, 3)) then
		topBot (2) := (topBot (2) + 1) mod 6
	    elsif (a > redFaceX (1, 1, 1) and a < redFaceX (1, 1, 3)) then
		if (b > -slope2*(a-redFaceX(1,1,2))+redFaceY(1,1,2) and b < -slope2*(a-redFaceX(1,1,1))+redFaceY(1,1,1)) then
		    frontTop (0) := (frontTop (0) + 1) mod 6
		elsif (b > -slope2*(a-redFaceX(2,1,2))+redFaceY(2,1,2) and b < -slope2*(a-redFaceX(2,1,1))+redFaceY(2,1,1)) then
		    frontMid (0) := (frontMid (0) + 1) mod 6
		elsif (b > -slope2*(a-redFaceX(3,1,2))+redFaceY(3,1,2) and b < -slope2*(a-redFaceX(3,1,1))+redFaceY(3,1,1)) then
		    frontBot (0) := (frontBot (0) + 1) mod 6
		end if
	    elsif (a > redFaceX (1, 2, 1) and a < redFaceX (1, 2, 3)) then
		if (b > -slope2*(a-redFaceX(1,2,2))+redFaceY(1,2,2) and b < -slope2*(a-redFaceX(1,2,1))+redFaceY(1,2,1)) then
		    frontTop (1) := (frontTop (1) + 1) mod 6
		elsif (b > -slope2*(a-redFaceX(3,2,2))+redFaceY(3,2,2) and b < -slope2*(a-redFaceX(3,2,1))+redFaceY(3,2,1)) then
		    frontBot (1) := (frontBot (1) + 1) mod 6
		end if
	    elsif (a > redFaceX (1, 3, 1) and a < redFaceX (1, 3, 3)) then
		if (b > -slope2*(a-redFaceX(1,3,2))+redFaceY(1,3,2) and b < -slope2*(a-redFaceX(1,3,1))+redFaceY(1,3,1)) then
		    frontTop (2) := (frontTop (2) + 1) mod 6
		elsif (b > -slope2*(a-redFaceX(2,3,2))+redFaceY(2,3,2) and b < -slope2*(a-redFaceX(2,3,1))+redFaceY(2,3,1)) then
		    frontMid (2) := (frontMid (2) + 1) mod 6
		elsif (b > -slope2*(a-redFaceX(3,3,2))+redFaceY(3,3,2) and b < -slope2*(a-redFaceX(3,3,1))+redFaceY(3,3,1)) then
		    frontBot (2) := (frontBot (2) + 1) mod 6
		end if
	    elsif (a > greenFaceX (1, 1, 1) and a < greenFaceX (1, 1, 3)) then
		if (b > slope2*(a-greenFaceX(1,1,2))+greenFaceY(1,1,2) and b < slope2*(a-greenFaceX(1,1,1))+greenFaceY(1,1,1)) then
		    rightTop (0) := (rightTop (0) + 1) mod 6
		elsif (b > slope2*(a-greenFaceX(2,1,2))+greenFaceY(2,1,2) and b < slope2*(a-greenFaceX(2,1,1))+greenFaceY(2,1,1)) then
		    rightMid (0) := (rightMid (0) + 1) mod 6
		elsif (b > slope2*(a-greenFaceX(3,1,2))+greenFaceY(3,1,2) and b < slope2*(a-greenFaceX(3,1,1))+greenFaceY(3,1,1)) then
		    rightBot (0) := (rightBot (0) + 1) mod 6
		end if
	    elsif (a > greenFaceX (1, 2, 1) and a < greenFaceX (1, 2, 3)) then
		if (b > slope2*(a-greenFaceX(1,2,2))+greenFaceY(1,2,2) and b < slope2*(a-greenFaceX(1,2,1))+greenFaceY(1,2,1)) then
		    rightTop (1) := (rightTop (1) + 1) mod 6
		elsif (b > slope2*(a-greenFaceX(3,2,2))+greenFaceY(3,2,2) and b < slope2*(a-greenFaceX(3,2,1))+greenFaceY(3,2,1)) then
		    rightBot (1) := (rightBot (1) + 1) mod 6
		end if
	    elsif (a > greenFaceX (1, 3, 1) and a < greenFaceX (1, 3, 3)) then
		if (b > slope2*(a-greenFaceX(1,3,2))+greenFaceY(1,3,2) and b < slope2*(a-greenFaceX(1,3,1))+greenFaceY(1,3,1)) then
		    rightTop (2) := (rightTop (2) + 1) mod 6
		elsif (b > slope2*(a-greenFaceX(2,3,2))+greenFaceY(2,3,2) and b < slope2*(a-greenFaceX(2,3,1))+greenFaceY(2,3,1)) then
		    rightMid (2) := (rightMid (2) + 1) mod 6
		elsif (b > slope2*(a-greenFaceX(3,3,2))+greenFaceY(3,3,2) and b < slope2*(a-greenFaceX(3,3,1))+greenFaceY(3,3,1)) then
		    rightBot (2) := (rightBot (2) + 1) mod 6
		end if
	    elsif (b < -slope * abs (wx1(1) - a) + wy1(1) and b > slope * abs (wx1(3) - a) + wy1(3)) then
		bottomTop (2) := (bottomTop (2) + 1) mod 6
	    elsif (b < -slope * abs (wx2(1) - a) + wy2(1) and b > slope * abs (wx2(3) - a) + wy2(3)) then
		bottomMid (2) := (bottomMid (2) + 1) mod 6
	    elsif (b < -slope * abs (wx3(1) - a) + wy3(1) and b > slope * abs (wx3(3) - a) + wy3(3)) then
		bottomBot (2) := (bottomBot (2) + 1) mod 6
	    elsif (b < -slope * abs (wx4(1) - a) + wy4(1) and b > slope * abs (wx4(3) - a) + wy4(3)) then
		bottomTop (1) := (bottomTop (1) + 1) mod 6
	    elsif (b < -slope * abs (wx6(1) - a) + wy6(1) and b > slope * abs (wx6(3) - a) + wy6(3)) then
		bottomBot (1) := (bottomBot (1) + 1) mod 6
	    elsif (b < -slope * abs (wx7(1) - a) + wy7(1) and b > slope * abs (wx7(3) - a) + wy7(3)) then
		bottomTop (0) := (bottomTop (0) + 1) mod 6
	    elsif (b < -slope * abs (wx8(1) - a) + wy8(1) and b > slope * abs (wx8(3) - a) + wy8(3)) then
		bottomMid (0) := (bottomMid (0) + 1) mod 6
	    elsif (b < -slope * abs (wx9(1) - a) + wy9(1) and b > slope * abs (wx9(3) - a) + wy9(3)) then
		bottomBot (0) := (bottomBot (0) + 1) mod 6
	    elsif (a > bx1(1) and a < bx1(3)) then
		if (b > -slope2*(a-bx1(2))+by1(2) and b < -slope2*(a-bx1(1))+by1(1)) then
		    leftBot (2) := (leftBot (2) + 1) mod 6
		elsif (b > -slope2*(a-bx4(2))+by4(2) and b < -slope2*(a-bx4(1))+by4(1)) then
		    leftMid (2) := (leftMid (2) + 1) mod 6
		elsif (b > -slope2*(a-bx7(2))+by7(2) and b < -slope2*(a-bx7(1))+by7(1)) then
		    leftTop (2) := (leftTop (2) + 1) mod 6
		end if
	    elsif (a > bx2(1) and a < bx2(3)) then
		if (b > -slope2*(a-bx2(2))+by2(2) and b < -slope2*(a-bx2(1))+by2(1)) then
		    leftBot (1) := (leftBot (1) + 1) mod 6
		elsif (b > -slope2*(a-bx8(2))+by8(2) and b < -slope2*(a-bx8(1))+by8(1)) then
		    leftTop (1) := (leftTop (1) + 1) mod 6
		end if
	    elsif (a > bx3(1) and a < bx3(3)) then
		if (b > -slope2*(a-bx3(2))+by3(2) and b < -slope2*(a-bx3(1))+by3(1)) then
		    leftBot (0) := (leftBot (0) + 1) mod 6
		elsif (b > -slope2*(a-bx6(2))+by6(2) and b < -slope2*(a-bx6(1))+by6(1)) then
		    leftMid (0) := (leftMid (0) + 1) mod 6
		elsif (b > -slope2*(a-bx9(2))+by9(2) and b < -slope2*(a-bx9(1))+by9(1)) then
		    leftTop (0) := (leftTop (0) + 1) mod 6
		end if
	    elsif (a > ox1(1) and a < ox1(3)) then
		if (b > slope2*(a-ox1(2))+oy1(2) and b < slope2*(a-ox1(1))+oy1(1)) then
		    backBot (2) := (backBot (2) + 1) mod 6
		elsif (b > slope2*(a-ox4(2))+oy4(2) and b < slope2*(a-ox4(1))+oy4(1)) then
		    backMid (2) := (backMid (2) + 1) mod 6
		elsif (b > slope2*(a-ox7(2))+oy7(2) and b < slope2*(a-ox7(1))+oy7(1)) then
		    backTop (2) := (backTop (2) + 1) mod 6
		end if
	    elsif (a > ox2(1) and a < ox2(3)) then
		if (b > slope2*(a-ox2(2))+oy2(2) and b < slope2*(a-ox2(1))+oy2(1)) then
		    backBot (1) := (backBot (1) + 1) mod 6
		elsif (b > slope2*(a-ox8(2))+oy8(2) and b < slope2*(a-ox8(1))+oy8(1)) then
		    backTop (1) := (backTop (1) + 1) mod 6
		end if
	    elsif (a > ox3(1) and a < ox3(3)) then
		if (b > slope2*(a-ox3(2))+oy3(2) and b < slope2*(a-ox3(1))+oy3(1)) then
		    backBot (0) := (backBot (0) + 1) mod 6
		elsif (b > slope2*(a-ox6(2))+oy6(2) and b < slope2*(a-ox6(1))+oy6(1)) then
		    backMid (0) := (backMid (0) + 1) mod 6
		elsif (b > slope2*(a-ox9(2))+oy9(2) and b < slope2*(a-ox9(1))+oy9(1)) then
		    backTop (0) := (backTop (0) + 1) mod 6
		end if
	    end if
	    bounce := false
	    first := true
	end if
    else
	bounce := true
    end if
end loop

var stremout :int %a var that is an int is needed to open a file 

open: stremout, "input.txt", put %this will open a connection to send data

var dBot : string := ""
var dMid : string := ""
var dTop : string := ""
var bBot : string := ""
var bMid : string := ""
var bTop : string := ""
var rBot : string := ""
var rMid : string := ""
var rTop : string := ""
var fBot : string := ""
var fMid : string := ""
var fTop : string := ""
var lBot : string := ""
var lMid : string := ""
var lTop : string := ""
var tBot : string := ""
var tMid : string := ""
var tTop : string := ""

function returnVal (temp : int) : string
    if temp = 0 then
	result "w"
    elsif (temp = 1) then
	result "o"
    elsif (temp = 2) then
	result "g"
    elsif (temp = 3) then
	result "r"
    elsif (temp = 4) then
	result "b"
    elsif (temp = 5) then
	result "y"
    end if
end returnVal

for i : 0 .. 2
    dBot := dBot + returnVal(bottomBot(i))
    dMid := dMid + returnVal(bottomMid(i))
    dTop := dTop + returnVal(bottomTop(i))
    bBot := bBot + returnVal(backBot(i))
    bMid := bMid + returnVal(backMid(i))
    bTop := bTop + returnVal(backTop(i))
    rBot := rBot + returnVal(rightBot(i))
    rMid := rMid + returnVal(rightMid(i))
    rTop := rTop + returnVal(rightTop(i))
    fBot := fBot + returnVal(frontBot(i))
    fMid := fMid + returnVal(frontMid(i))
    fTop := fTop + returnVal(frontTop(i))
    lBot := lBot + returnVal(leftBot(i))
    lMid := lMid + returnVal(leftMid(i))
    lTop := lTop + returnVal(leftTop(i))
    tBot := tBot + returnVal(topBot(i))
    tMid := tMid + returnVal(topMid(i))
    tTop := tTop + returnVal(topTop(i))
end for

put: stremout, dTop
put: stremout, dMid
put: stremout, dBot
put: stremout, bTop
put: stremout, bMid
put: stremout, bBot
put: stremout, rTop
put: stremout, rMid
put: stremout, rBot
put: stremout, fTop
put: stremout, fMid
put: stremout, fBot
put: stremout, lTop
put: stremout, lMid
put: stremout, lBot
put: stremout, tTop
put: stremout, tMid
put: stremout, tBot
close: stremout 
