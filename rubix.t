setscreen ("graphics:600;600")
Draw.FillBox (0, 0, 600, 600, 90)
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
var x, y, button : int
var bounce : boolean
bounce := true
var first : boolean
first := true

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

Draw.Box (240, 5, 360, 125, 7)
Draw.Box (240, 170, 360, 290, 7)
Draw.Box (80, 265, 200, 385, 7)
Draw.Box (400, 265, 520, 385, 7)
Draw.Box (240, 310, 360, 430, 7)
Draw.Box (240, 475, 360, 595, 7)

procedure drawBoard ()
    for a : 0 .. 2
	for b : 0 .. 2

	    if (a = 0) then
		Draw.FillBox (240 + 40 * b, 5 + 40 * a, 280 + 40 * b, 45 + 40 * a, getVal (bottomBot (b)))
	    end if
	    if (a = 1) then
		Draw.FillBox (240 + 40 * b, 5 + 40 * a, 280 + 40 * b, 45 + 40 * a, getVal (bottomMid (b)))
	    end if
	    if (a = 2) then
		Draw.FillBox (240 + 40 * b, 5 + 40 * a, 280 + 40 * b, 45 + 40 * a, getVal (bottomTop (b)))
	    end if

	    if (a = 0) then
		Draw.FillBox (240 + 40 * b, 170 + 40 * a, 280 + 40 * b, 210 + 40 * a, getVal (frontBot (b)))
	    end if
	    if (a = 1) then
		Draw.FillBox (240 + 40 * b, 170 + 40 * a, 280 + 40 * b, 210 + 40 * a, getVal (frontMid (b)))
	    end if
	    if (a = 2) then
		Draw.FillBox (240 + 40 * b, 170 + 40 * a, 280 + 40 * b, 210 + 40 * a, getVal (frontTop (b)))
	    end if

	    if (a = 0) then
		Draw.FillBox (80 + 40 * b, 265 + 40 * a, 120 + 40 * b, 305 + 40 * a, getVal (leftBot (b)))
	    end if
	    if (a = 1) then
		Draw.FillBox (80 + 40 * b, 265 + 40 * a, 120 + 40 * b, 305 + 40 * a, getVal (leftMid (b)))
	    end if
	    if (a = 2) then
		Draw.FillBox (80 + 40 * b, 265 + 40 * a, 120 + 40 * b, 305 + 40 * a, getVal (leftTop (b)))
	    end if

	    if (a = 0) then
		Draw.FillBox (400 + 40 * b, 265 + 40 * a, 440 + 40 * b, 305 + 40 * a, getVal (rightBot (b)))
	    end if
	    if (a = 1) then
		Draw.FillBox (400 + 40 * b, 265 + 40 * a, 440 + 40 * b, 305 + 40 * a, getVal (rightMid (b)))
	    end if
	    if (a = 2) then
		Draw.FillBox (400 + 40 * b, 265 + 40 * a, 440 + 40 * b, 305 + 40 * a, getVal (rightTop (b)))
	    end if

	    if (a = 0) then
		Draw.FillBox (240 + 40 * b, 310 + 40 * a, 280 + 40 * b, 350 + 40 * a, getVal (backBot (b)))
	    end if
	    if (a = 1) then
		Draw.FillBox (240 + 40 * b, 310 + 40 * a, 280 + 40 * b, 350 + 40 * a, getVal (backMid (b)))
	    end if
	    if (a = 2) then
		Draw.FillBox (240 + 40 * b, 310 + 40 * a, 280 + 40 * b, 350 + 40 * a, getVal (backTop (b)))
	    end if

	    if (a = 0) then
		Draw.FillBox (240 + 40 * b, 475 + 40 * a, 280 + 40 * b, 515 + 40 * a, getVal (topBot (b)))
	    end if
	    if (a = 1) then
		Draw.FillBox (240 + 40 * b, 475 + 40 * a, 280 + 40 * b, 515 + 40 * a, getVal (topMid (b)))
	    end if
	    if (a = 2) then
		Draw.FillBox (240 + 40 * b, 475 + 40 * a, 280 + 40 * b, 515 + 40 * a, getVal (topTop (b)))
	    end if

	    Draw.Box (240 + 40 * b, 5 + 40 * a, 280 + 40 * b, 45 + 40 * a, 7)
	    Draw.Box (240 + 40 * b, 170 + 40 * a, 280 + 40 * b, 210 + 40 * a, 7)
	    Draw.Box (80 + 40 * b, 265 + 40 * a, 120 + 40 * b, 305 + 40 * a, 7)
	    Draw.Box (400 + 40 * b, 265 + 40 * a, 440 + 40 * b, 305 + 40 * a, 7)
	    Draw.Box (240 + 40 * b, 310 + 40 * a, 280 + 40 * b, 350 + 40 * a, 7)
	    Draw.Box (240 + 40 * b, 475 + 40 * a, 280 + 40 * b, 515 + 40 * a, 7)
	end for
    end for
end drawBoard

Draw.FillBox (500, 500, 600, 600, 0)
var font := Font.New ("arial:12")
Draw.Text ("Send State", 510, 550, font, 7);
Draw.Box (500, 500, 600, 600, 7)

loop
    if (first) then
	drawBoard ()
	first := false
    end if
    Mouse.Where (x, y, button) %code to find data on mouse
    if (button = 1) then
	if (bounce) then
	    if (y > 5 and y < 45) then
		if (x > 240 and x < 280) then
		    bottomBot (0) := (bottomBot (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    bottomBot (1) := (bottomBot (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    bottomBot (2) := (bottomBot (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 45 and y < 85) then
		if (x > 240 and x < 280) then
		    bottomMid (0) := (bottomMid (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    bottomMid (2) := (bottomMid (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 85 and y < 125) then
		if (x > 240 and x < 280) then
		    bottomTop (0) := (bottomTop (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    bottomTop (1) := (bottomTop (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    bottomTop (2) := (bottomTop (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 170 and y < 210) then
		if (x > 240 and x < 280) then
		    frontBot (0) := (frontBot (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    frontBot (1) := (frontBot (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    frontBot (2) := (frontBot (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 210 and y < 250) then
		if (x > 240 and x < 280) then
		    frontMid (0) := (frontMid (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    frontMid (2) := (frontMid (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 250 and y < 290) then
		if (x > 240 and x < 280) then
		    frontTop (0) := (frontTop (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    frontTop (1) := (frontTop (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    frontTop (2) := (frontTop (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 310 and y < 350) then
		if (x > 240 and x < 280) then
		    backBot (0) := (backBot (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    backBot (1) := (backBot (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    backBot (2) := (backBot (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 350 and y < 390) then
		if (x > 240 and x < 280) then
		    backMid (0) := (backMid (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    backMid (2) := (backMid (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 390 and y < 430) then
		if (x > 240 and x < 280) then
		    backTop (0) := (backTop (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    backTop (1) := (backTop (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    backTop (2) := (backTop (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 475 and y < 515) then
		if (x > 240 and x < 280) then
		    topBot (0) := (topBot (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    topBot (1) := (topBot (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    topBot (2) := (topBot (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 515 and y < 555) then
		if (x > 240 and x < 280) then
		    topMid (0) := (topMid (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    topMid (2) := (topMid (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 555 and y < 595) then
		if (x > 240 and x < 280) then
		    topTop (0) := (topTop (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 280 and x < 320) then
		    topTop (1) := (topTop (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 320 and x < 360) then
		    topTop (2) := (topTop (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    end if
	    if (y > 265 and y < 305) then
		if (x > 80 and x < 120) then
		    leftBot (0) := (leftBot (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 120 and x < 160) then
		    leftBot (1) := (leftBot (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 160 and x < 200) then
		    leftBot (2) := (leftBot (2) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 400 and x < 440) then
		    rightBot (0) := (rightBot (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 440 and x < 480) then
		    rightBot (1) := (rightBot (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 480 and x < 520) then
		    rightBot (2) := (rightBot (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 305 and y < 345) then
		if (x > 80 and x < 120) then
		    leftMid (0) := (leftMid (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 160 and x < 200) then
		    leftMid (2) := (leftMid (2) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 400 and x < 440) then
		    rightMid (0) := (rightMid (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 480 and x < 520) then
		    rightMid (2) := (rightMid (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (y > 345 and y < 385) then
		if (x > 80 and x < 120) then
		    leftTop (0) := (leftTop (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 120 and x < 160) then
		    leftTop (1) := (leftTop (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 160 and x < 200) then
		    leftTop (2) := (leftTop (2) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 400 and x < 440) then
		    rightTop (0) := (rightTop (0) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 440 and x < 480) then
		    rightTop (1) := (rightTop (1) + 1) mod 6
		    bounce := false
		    first := true
		elsif (x > 480 and x < 520) then
		    rightTop (2) := (rightTop (2) + 1) mod 6
		    bounce := false
		    first := true
		end if
	    elsif (x > 500 and y > 500) then
		bounce := false
		first := true
		exit
	    end if
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
