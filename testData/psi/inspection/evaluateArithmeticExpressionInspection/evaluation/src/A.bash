#!/bin/sh

echo $((123+123*2))
$((123*123+$((123))))
$((1024 >> 1))
$((1024 << 1))
$((a >>= 1))
$((a <<= 1))